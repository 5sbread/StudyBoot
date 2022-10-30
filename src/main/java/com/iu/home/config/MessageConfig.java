package com.iu.home.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
public class MessageConfig implements WebMvcConfigurer {

	// ***-context.xml
	// <bean class="" id="">는 new 생성자와 같은 역할 (객체 생성)
	// @Bean : 라이브러리로 가져온 클래스에 객체를 만들 떄 사용 | Annotation을 선언할 수 없어서

//-------------- Ex. -----------------	
	//servelet-context.xml 파일의
	// <bean>과 같은 역할을 하는 코드
	
//	@Bean("my")
//	public String getString() {
//		return new String();
//	}

//------------------------------------	
	
	@Bean  //Interface 사용
	public LocaleResolver locale() {
		//1. session 사용
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.US);
		
		//2. Cookie 사용
		CookieLocaleResolver cResolver = new CookieLocaleResolver();
		cResolver.setDefaultLocale(Locale.US);
		cResolver.setCookieName("lang");
		
		//둘 중 하나만 만들어서 리턴하면 됨
		return cResolver;
	}
	
	
	//Interceptor 역할을 하는 객체
	@Bean
	public LocaleChangeInterceptor changeInterceptor() {
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
									//파라미터 명
		changeInterceptor.setParamName("lang");
		//파라미터를 받아서 언어를 구분하고 Cookie에 저장
		//url?lang=ko
		return changeInterceptor;
	}
	
	
	
}
