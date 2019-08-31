package group.slsd.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.GenericFilterBean;

import group.slsd.config.filter.LoginVerifyCodeFilter;
import group.slsd.config.handler.MyAccessDeniedHandler;
import group.slsd.controller.VerificationController;
import group.slsd.service.ManVoServiceImpl;
import group.slsd.service.OwnerService;
import group.slsd.utils.SessionManagerUtil;
import group.slsd.vo.ManVo;
import group.slsd.vo.OwnerVo;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description：安全角色配置
 * @author 0
 * @date 2019年8月26日 下午12:50:48
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 
	 * @Title：loginVerifyCodeFilter
	 * @Description：添加验证码过滤器到过滤链中
	 */
	// 过滤器
	public GenericFilterBean loginVerifyCodeFilter() {
		LoginVerifyCodeFilter verifyCodeFilter = new LoginVerifyCodeFilter("/loginVerify");
		verifyCodeFilter.setCodeCreateTimeName(VerificationController.CODE_CREATE_TIME);
		verifyCodeFilter.setRequestCodeName(VerificationController.CODE);
		verifyCodeFilter.setCodeliveTime(60000);
		return verifyCodeFilter;
	}

	/**
	 * 
	 * @Title：corsFilter
	 * @Description：配置跨域
	 */

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		return new CorsFilter(source);
	}

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

	/**
	 * 
	 * @Title：characterEncodingFilter
	 * @Description：配置UTF-8编码
	 */
	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setForceEncoding(true);
		characterEncodingFilter.setEncoding("UTF-8");
		return characterEncodingFilter;
	}

	/**
	 * 授权代理
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/*
	 * 暂时不检查权限
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// session 会话
		SessionManagementConfigurer<HttpSecurity> sessionManagement = http.sessionManagement();
		MySessionAuthenticationStrategy strategy = new MySessionAuthenticationStrategy(new SessionRegistryImpl());
		sessionManagement.sessionAuthenticationStrategy(strategy);

		// 编码
		http.addFilterBefore(characterEncodingFilter(), HeaderWriterFilter.class);

		// 验证码
		http.addFilterBefore(loginVerifyCodeFilter(), UsernamePasswordAuthenticationFilter.class);

		http.formLogin().loginProcessingUrl("/loginVerify");

		http.headers().frameOptions().disable();

		http.exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler());

		// @formatter:off
		http.cors().and().csrf().disable().authorizeRequests()
				// 处理跨域请求中的Preflight请求
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				// .antMatchers("/**").permitAll()
				.anyRequest().permitAll();
		// @formatter:on
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	/**
	 * 
	 * @Description：用户登录授权
	 * @author 0
	 * @date 2019年8月30日 下午1:35:17
	 */
	@Component
	public static class MyUserDetailService implements UserDetailsService {

		@Autowired
		private ManVoServiceImpl manVoService;
		@Autowired
		private OwnerService ownerService;

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			List<ManVo> manVoList = manVoService.selectManByUsername(username);
			// 管理员
			if (manVoList != null && !manVoList.isEmpty()) {
				String pwd = manVoList.get(0).getPwd();
				Set<GrantedAuthority> dbAuthsSet = new HashSet<>();
				dbAuthsSet.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				List<GrantedAuthority> dbAuths = new ArrayList<>(dbAuthsSet);
				// String username, String password, boolean enabled,
				// boolean accountNonExpired, boolean credentialsNonExpired,
				// boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities
				return new User(username, pwd, true, true, true, true, dbAuths);
			}
			// 业主
			List<OwnerVo> ownerVoList = ownerService.selectOwnerByUsername(username);
			if (ownerVoList != null && !ownerVoList.isEmpty()) {
				String ownerPwd = ownerVoList.get(0).getPwd();
				Set<GrantedAuthority> dbAuthsSet = new HashSet<>();
				dbAuthsSet.add(new SimpleGrantedAuthority("ROLE_OWNER"));
				List<GrantedAuthority> dbAuths = new ArrayList<>(dbAuthsSet);
				return new User(username, ownerPwd, true, true, true, true, dbAuths);
			}
			throw new UsernameNotFoundException("用户名未找到");
		}

	}

	/**
	 * @Description：多人会话策略
	 * @author 0
	 * @date 2019年8月28日 下午6:49:52
	 */

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

	/**
	 * 
	 * @Description：Session 会话监听器
	 * @author 0
	 * @date 2019年8月30日 上午9:03:20
	 */
	@Component
	@Slf4j
	public static class MyHttpSessionListener extends HttpSessionEventPublisher {

		@Override
		public void sessionCreated(HttpSessionEvent event) {
			super.sessionCreated(event);

			HttpSession session = event.getSession();
			String id = session.getId();
			log.info("sessionCreated id = {}", id);

		}

		@Override
		public void sessionDestroyed(HttpSessionEvent event) {
			super.sessionDestroyed(event);
			HttpSession session = event.getSession();
			String id = session.getId();
			log.info("sessionDestroyed id = {}", id);

		}

	}
}
