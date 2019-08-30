package group.slsd.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.NonNull;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description：登录的验证码验证
 * @author 0
 * @date 2019年8月30日 下午10:10:58
 */
@Slf4j
public class LoginVerifyCodeFilter extends GenericFilterBean {

	private AntPathRequestMatcher antPathRequestMatcher;

	@NonNull
	private String requestCodeName;

	@NonNull
	private String codeCreateTimeName;

	@NonNull
	private Long codeliveTime;

	public LoginVerifyCodeFilter() {
		antPathRequestMatcher = new AntPathRequestMatcher("/login", "POST");
	}
	
	public LoginVerifyCodeFilter(String codeUrl ) {
		antPathRequestMatcher = new AntPathRequestMatcher(codeUrl, "POST");
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("LoginVerifyCodeFilter"+ response.getCharacterEncoding());

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (!antPathRequestMatcher.matches(httpRequest)) {
			chain.doFilter(request, response);
			return ;
		}
		// 拦截验证码登录
		HttpSession session = httpRequest.getSession(false);
		if (session == null || request.getAttribute(requestCodeName) == null) {
			// chain.doFilter(request, response); 验证失败
			sendMsg(httpResponse, new String("验证码不存在".getBytes(),"UTF-8"));
			return;
		}
		Long oldTime = (Long) session.getAttribute(codeCreateTimeName);
		if (expire(oldTime, System.currentTimeMillis())) {
			sendMsg(httpResponse, "验证码超时");
			return;
		}
		String rawCode = (String) session.getAttribute(requestCodeName);
		String verifyCode = (String) request.getAttribute(requestCodeName);

		// 验证失败
		if (!rawCode.equals(verifyCode)) {
			sendMsg(httpResponse, "验证码错误");
			return ;
		}

		chain.doFilter(request, response);
	}

	private void sendMsg(ServletResponse response, String msg) throws IOException {
		try {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(getErrorMsg(msg));
		} finally {
			response.getWriter().flush();
			response.getWriter().close();
		}
	}

	private String getErrorMsg(String msg) {
		// 验证码不存在
		return "{\"code\":\"401\",\"msg\":\"" + msg + "\"}";
	}

	private boolean expire(Long oldTime, Long newTime) {
		return oldTime + codeliveTime < newTime;
	}

	public String getRequestCodeName() {
		return requestCodeName;
	}

	public void setRequestCodeName(String requestCodeName) {
		this.requestCodeName = requestCodeName;
	}

	public String getCodeCreateTimeName() {
		return codeCreateTimeName;
	}

	public void setCodeCreateTimeName(String codeCreateTimeName) {
		this.codeCreateTimeName = codeCreateTimeName;
	}

	public Long getCodeliveTime() {
		return codeliveTime;
	}

	public void setCodeliveTime(long codeliveTime2) {
		this.codeliveTime = codeliveTime;
		
	}
	
	

}
