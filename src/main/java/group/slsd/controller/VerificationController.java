package group.slsd.controller;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import group.slsd.validator.PhoneConstraintValidator;
import group.slsd.validator.SimplePhoneValidator;
import group.slsd.validator.annotation.Phone;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("code")
@Slf4j
@ConfigurationProperties(prefix = "aliyun")
public class VerificationController {

	// 手机号验证
	private Pattern p = Pattern.compile("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$");
	public static final String CODE = "CODE";
	public static final String EXPIRE_TIME = "EXPIRE_TIME";

	private String accessKeyId;

	private String accessSecret;

	@Autowired
	private JavaMailSender mailSender;

	@PostMapping("test")
	public ResponseEntity<String> refreshVerificationCode(String phone) {

		Assert.notNull(accessKeyId, "不能为空");
		Assert.hasText(phone, "电话号码不能为空");

		log.info("phone: {}", phone);
		return ResponseEntity.ok("200");
	}

	/**
	 * 
	 * @Title：sendCodeByEmail
	 * @Description：邮箱注册业务
	 * @param ：@param  email
	 * @param ：@param  request
	 * @param ：@return
	 * @return ：Callable<String>
	 */
	@PostMapping("sendCodeByEmail")
	public Callable<String> sendCodeByEmail(String email, HttpServletRequest request) {

		String code = "123456";
		HttpSession session = request.getSession();
		session.setAttribute(CODE, code);
		session.setAttribute(EXPIRE_TIME, System.currentTimeMillis());

		return new Callable<String>() {
			@Override
			public String call() {
				try {
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
					messageHelper.setFrom(((JavaMailSenderImpl) mailSender).getUsername());
					messageHelper.setTo(email);
					messageHelper.setSubject("[小.区.物.业]>");
					String html = "<html><p>验证码:" + code + "</p></html>";
					messageHelper.setText(html, true);
					mailSender.send(message);
				} catch (MessagingException e) {
					e.printStackTrace();
					return "500";
				}
				return "200";
			}
		};
	}

	/**
	 * @Title：sendCodeBySMS
	 * 
	 * @Description：短信注册业务
	 * @param ：@param phone 电话号码
	 * @param ：@param request 请求 "{\"Message\":\"OK\",
	 *                \"RequestId\":\"12E641A6-5F6D-4884-96DE-D3E8D95FBDAF\",
	 *                \"BizId\":\"628218067090138941^0\", \"Code\":\"OK\" }"
	 */
	@PostMapping("sendCodeBySMS")
	public Callable<ResponseEntity<String>> sendCodeBySMS(@RequestParam String phone, HttpServletRequest request) {
		return new Callable<ResponseEntity<String>>() {
			@Override
			public ResponseEntity<String> call() {

				Matcher matcher = p.matcher(phone);
				if (!matcher.matches()) {
					return ResponseEntity.badRequest().body("非法电话");
				}
				String code = "123456";
				HttpSession session = request.getSession();
				session.setAttribute(CODE, code);
				session.setAttribute(EXPIRE_TIME, System.currentTimeMillis());

				DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
				IAcsClient client = new DefaultAcsClient(profile);
				CommonRequest request = new CommonRequest();
				request.setMethod(MethodType.POST);
				request.setDomain("dysmsapi.aliyuncs.com");
				request.setVersion("2017-05-25");
				request.setAction("SendSms");
				request.putQueryParameter("RegionId", "cn-hangzhou");
				request.putQueryParameter("PhoneNumbers", "15606885785");
				request.putQueryParameter("SignName", "皮革厂的孤巢老人");
				request.putQueryParameter("TemplateCode", "SMS_173340246");
				request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
				try {
					CommonResponse response = client.getCommonResponse(request);
					return ResponseEntity.ok(response.getData());
				} catch (ServerException e) {
					e.printStackTrace();
					return ResponseEntity.badRequest().build();
				} catch (ClientException e) {
					e.printStackTrace();
					return ResponseEntity.badRequest().build();
				}
			}
		};
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessSecret() {
		return accessSecret;
	}

	public void setAccessSecret(String accessSecret) {
		this.accessSecret = accessSecret;
	}

}
