package group.slsd.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import group.slsd.config.WebSecurityConfig.MySessionAuthenticationStrategy;
import group.slsd.utils.SessionManagerUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description：安全角色配置
 * @author 0
 * @date 2019年8月26日 下午12:50:48
 */
@Configuration
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		return new CorsFilter(source);
	}

	/*
	 * 暂时不检查权限
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		SessionManagementConfigurer<HttpSecurity> sessionManagement = http.sessionManagement();
		// session 会话
		MySessionAuthenticationStrategy strategy = new MySessionAuthenticationStrategy(new SessionRegistryImpl());
		sessionManagement.sessionAuthenticationStrategy(strategy);

		http.headers().frameOptions().disable();

		http.cors().and().csrf().disable().authorizeRequests()
				// 处理跨域请求中的Preflight请求
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				// .antMatchers("/**").permitAll()
				.anyRequest().permitAll();
	}

	public class MySessionAuthenticationStrategy extends ConcurrentSessionControlAuthenticationStrategy {

		public MySessionAuthenticationStrategy(SessionRegistry sessionRegistry) {
			super(sessionRegistry);
		}

		/**
		 * 
		 * sessionCount > allowedSessions
		 * 
		 * sessions 当前未过期的 session
		 * 
		 */

		@Override
		protected void allowableSessionsExceeded(List<SessionInformation> sessions, int allowableSessions,
				SessionRegistry registry) throws SessionAuthenticationException {
			SessionInformation sessionInformation = sessions.get(0);
			Object principal = sessionInformation.getPrincipal();
			
			Integer count = SessionManagerUtil.getUserOnlineCount(principal);
			SessionManagerUtil.setUserOnlineCount(principal, count + 1);

		}
	}
}
