package com.iu.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
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
	SecurityFilterChain fiterChain(HttpSecurity httpSecurity)throws Exception{
		httpSecurity
			.cors()
			.and()
			.csrf()
			.disable()
			
			// 어떤 URL의 요청에 권한을 설정
			//순서 중요
		.authorizeRequests()
			.antMatchers("/").permitAll() // 주소 "/"(현재 인덱스 페이지)는 모두에게 허용
			.antMatchers("/login").permitAll()
			.antMatchers("/logout").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/manager").hasAnyRole("ADMIN", "MANAGER")
			.antMatchers("/qna/list").permitAll() // list는 모두 허용
			.antMatchers("/qna/**").hasRole("MEMBER") //list 제외 멤버에게 허용
			.anyRequest().permitAll()
			.and() //설정 끝
		
		.formLogin() //새 설정 시작
			.loginPage("/member/login") //내장된 로그인폼 사용 X | 내가 만든 로그인폼 요청URL
			//.loginProcessingUrl("login") //로그인을 요청할 form 태그의 action 주소 지정
			.usernameParameter("id") // 아이디 파라미터 명 지정 | 기본 : username
			.passwordParameter("pw") // 비밀번호 파라미터 명 지정 | 기본 : password
			.defaultSuccessUrl("/") //로그인 성공시
			.failureUrl("/member/login") //로그인 실패시
			.permitAll()
			.and()
			
		.logout()
			.logoutUrl("out")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.permitAll(); // 마지막엔 세미콜론
		
		return httpSecurity.build();				
		}	
	
	
	//평문(Clear Text)을 암호화 시켜주는 객체생성
	@Bean
	public PasswordEncoder getEncoder () {
		return new BCryptPasswordEncoder();
	}
				
	
	
	
	
	
	
}
