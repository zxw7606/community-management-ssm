package group.slsd.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;

import group.slsd.service.RepairOrderServiceImpl;
import group.slsd.vo.RepairOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "缴费单")
@RestController
@RequestMapping("pay")
@PropertySource("classpath:alipay.properties")
@Slf4j
public class PayController {
	@Value("${ali.appid}")
	public String appid;
	@Value("${ali.rsa_priavte_key}")
	public String rsa_priavte_key;
	@Value("${notify_url}")
	public String notify_url;
	@Value("${return_url}")
	public String return_url;
	@Value("${ali.gateway_url}")
	public String gateway_url;
	@Value("${ali.charset}")
	public String charset;
	@Value("${ali.format}")
	public String format;
	@Value("${ali.public_key}")
	public String public_key;
	@Value("${ali.logpath}")
	public String logPath;
	@Value("${ali.sign_type}")
	public String signType;

	@Autowired
	private RepairOrderServiceImpl repairOrderService;

	@ApiOperation("添加维修单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "tradeName", value = "维修名称", required = true, paramType = "form", dataType = "String"),
			@ApiImplicitParam(name = "ownerName", value = "物主名", required = true, paramType = "form", dataType = "String") })
	@PostMapping("addRepairOrder")
	public ResponseEntity<String> addRepairOrder(@Valid RepairOrderVo repairOrderVo, BindingResult br) {

		// 检查错误
		if (br.hasErrors()) {
			StringBuffer buffer = new StringBuffer();
			List<ObjectError> errors = br.getAllErrors();
			for (ObjectError e : errors) {
				buffer.append(String.format("%s:%s:%s\n", e.getObjectName(), e.getCode(), e.getDefaultMessage()));
			}
			return ResponseEntity.badRequest().body(buffer.toString());
		}
		// insert
		repairOrderVo.setTradeStatus("待支付");
		repairOrderService.insertSelective(repairOrderVo);
		return ResponseEntity.ok("200");

	}

	@ApiOperation("获取所有维修单")
	@GetMapping("getRepairOrder")
	public List<RepairOrderVo> getRepairOrder() {
		List<RepairOrderVo> reList = repairOrderService.findAll();
		return reList;
	}

	@ApiOperation("支付网页端维修单")
	@Transactional
	@GetMapping("payWebRepairOrder/{id}/{totalMount}")
	public void payWebRepairOrder(@PathVariable("id") @ApiParam("订单id") Integer id,
			@PathVariable("totalMount") @ApiParam("价格") BigDecimal totalMount, HttpServletResponse response)
			throws Exception {
		RepairOrderVo repairOrderVo = repairOrderService.selectByPrimaryKey(id);
		if (repairOrderVo == null) {
			throw new RuntimeException("订单不存在");
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String out_trade_no = dateFormat.format(new Date());

		repairOrderVo.setOutTradeNo(out_trade_no);
		repairOrderVo.setNum(1);// 数量
		repairOrderVo.setTotalMount(totalMount);
		repairOrderVo.setTradeStatus("正在支付");

		// 请求生成订单
		AlipayClient client = new DefaultAlipayClient(gateway_url, appid, rsa_priavte_key, format, charset, public_key,
				signType);

		// 封装请求支付信息
		AlipayTradePagePayModel model = new AlipayTradePagePayModel();
		model.setOutTradeNo(repairOrderVo.getOutTradeNo()); // 必填
		model.setSubject(repairOrderVo.getTradeName());// 必填
		model.setProductCode("FAST_INSTANT_TRADE_PAY");
		BigDecimal mount = repairOrderVo.getTotalMount();
		String totalAmount = mount.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		model.setTotalAmount(totalAmount); // 必填

		model.setTimeoutExpress("15m");

		AlipayTradePagePayRequest alipay_request = new AlipayTradePagePayRequest();
		alipay_request.setBizModel(model);

		// 设置同步地址
		alipay_request.setReturnUrl(return_url);
		alipay_request.setReturnUrl(notify_url);
		try {
			AlipayTradePagePayResponse pagePayResponse = client.pageExecute(alipay_request);
			if (pagePayResponse.isSuccess()) {
				// 更新订单
				repairOrderService.updateByPrimaryKeySelective(repairOrderVo);
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(pagePayResponse.getBody());
				response.getWriter().flush();
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@RequestMapping(value = "notify_url")
	@ApiOperation("支付回调")
	@Transactional
	public ResponseEntity notify_url(@RequestParam Map<String, String> params) throws AlipayApiException {
		try {
			boolean verify_result = AlipaySignature.rsaCheckV1(params, public_key, charset, "RSA2");
			log.warn("支付宝验证状态:{}", verify_result);

			String out_trade_no = params.get("out_trade_no");
			String trade_no = params.get("trade_no");
			String trade_status = params.get("trade_status");
			if (trade_status.equals("TRADE_FINISHED")) {
				// 订单是处理过的 比如退款的回调也在这？？？
			} else if (trade_status.equals("TRADE_SUCCESS")) {
				log.warn("支付成功");
				RepairOrderVo repairOrderVo = repairOrderService.selectByOutTradeNo(out_trade_no);
				repairOrderVo.setTradeStatus("已支付");
				repairOrderVo.setTradeNo(trade_no);
				repairOrderService.updateByPrimaryKeySelective(repairOrderVo);
				return ResponseEntity.ok("支付成功");
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
			throw e;
		}
		return ResponseEntity.ok("支付失败");

	}

}
