package com.iu.home.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.iu.home.member.MemberSecurityService;
import com.iu.home.member.MemberSocialService;
import com.iu.home.member.security.LoginFail;
import com.iu.home.member.security.LoginSeccess;
import com.iu.home.member.security.LogoutCustom;
import com.iu.home.member.security.LogoutSuccessCustom;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private LoginSeccess loginSuccess;
	
	@Autowired
	private LoginFail loginFail;
	
	@Autowired
	private LogoutCustom logoutCustom;
	
	@Autowired
	private LogoutSuccessCustom logoutSeccessCustom;
	
	@Autowired
	private MemberSecurityService memberSecurityService;
	
	@Autowired
	private MemberSocialService memberSocialService;
	
	
	
	
	@Bean
	//public 선언하면 default로 바꾸라는 메세지 뜸
	WebSecurityCustomizer webSecurityConfig () {
		// Security에서 무시해야하는 URL 패턴 등록
		return web -> web
					.ignoring()
					// ↓ 얘네는 보안이랑 상관없어서
					.antMatchers("/images/**")
				    .antMatchers("/css/**")
				    .antMatchers("/js/**")
				    .antMatchers("/favicon/**")
				    .antMatchers("/resources/**");
		}

	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity security)throws Exception{
		security
			.csrf()
			.disable()
			.cors()
			.configurationSource(this.corsConfigurationSource())
			.and()
			
			// 어떤 URL의 요청에 권한을 설정
			//순서 중요
		.authorizeRequests()
			.antMatchers("/").permitAll() // 주소 "/"(현재 인덱스 페이지)는 모두에게 허용
			.antMatchers("/login").permitAll()
			.antMatchers("/logout").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/manager").hasAnyRole("ADMIN", "MANAGER")
			.antMatchers("/qna/list").permitAll() // list는 모두 허용
			//.antMatchers("/qna/**").hasRole("MEMBER") //list 제외 멤버에게 허용
			.anyRequest().permitAll()
			.and() //설정 끝
		
		.formLogin() //새 설정 시작
			.loginPage("/member/login") //내장된 로그인폼 사용 X | 내가 만든 로그인폼 요청URL
			//.loginProcessingUrl("login") //로그인을 요청할 form 태그의 action 주소 지정
			.usernameParameter("id") // 아이디 파라미터 명 지정 | 기본 : username
			.passwordParameter("pw") // 비밀번호 파라미터 명 지정 | 기본 : password
			.defaultSuccessUrl("/") //로그인 성공시
			//.failureUrl("/member/login?error=true&message=LoginFail") //로그인 실패시
			.failureHandler(loginFail)
			.permitAll()
			.and()
			
		.logout()
			.logoutUrl("/member/logout")
			//.logoutSuccessUrl("/")
			.addLogoutHandler(logoutCustom) // 로그아웃 시 해야할 일을 구성
			.logoutSuccessHandler(logoutSeccessCustom) // 로그아웃 성공 후 해야할 일을 구성
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.permitAll() // 마지막엔 세미콜론
			.and()
			
		.rememberMe() //RememberMe 실행
			.rememberMeParameter("rememberMe") //기본 : remember me
			.tokenValiditySeconds(300) //로그인 유지 시간 | 초 단위
			.key("rememberMe") //인증받은 사용자의 정보로 Token 생성시 필요, 필수값
			.userDetailsService(memberSecurityService) //인증절차를 실행할 UserDetailsService | 필수
			.authenticationSuccessHandler(loginSuccess) //로그인 성공 Handler
			.and()
			
//		.oauth2Login()	// Social Login 설정
//			.userInfoEndpoint()
//			.userService(memberSocialService)
			;
		
		
		return security.build();				
		}	
	
	
	//평문(Clear Text)을 암호화 시켜주는 객체생성
	@Bean
	public PasswordEncoder getEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	
	
	//@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:5500", "http://192.168.1.20:5500", "http://192.168.1.2:5500", "*"));
						// Allowed : 이쪽 URL로 오는것은 허락
						// <T> : 타입
						// ...a : 여러개 넣을 수 있음
		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		return (CorsConfigurationSource) source;
	}
				
		
	
	
	
	
}
