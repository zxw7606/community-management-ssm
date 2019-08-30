package group.slsd.config.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description：权限验证失败后的处理
 * @author 0
 * @date 2019年8月30日 下午10:11:36
 */
@Slf4j
public class MyAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.warn(accessDeniedException.getMessage());
		
		String error = "{\"code\":\"403\",\"msg\":\"想干啥\"}";
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(error);

		} finally {
			response.getWriter().flush();
		}

	}

}
