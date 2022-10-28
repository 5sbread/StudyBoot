package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.iu.home.Interceptors.TestInterceptor;
import com.iu.home.Interceptors.studyInterceptor;

import lombok.extern.slf4j.Slf4j;

//Legacy의 ***-context.xml 역할

@Configuration //설정 파일이라는 뜻
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired //의존성 주입 - IOC(Inversion of Control)
	private TestInterceptor testInterceptor;
	@Autowired
	private studyInterceptor studyInterceptor;
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;

	@Override
		public void addInterceptors(InterceptorRegistry registry) {
			//method chaining : 메서드를 끊지 않고 연결하는 방식
					//적용할 Interceptor 등록
			registry.addInterceptor(testInterceptor)
					//Interceptor를 적용할 URL 등록
					.addPathPatterns("/qna/**")
					.addPathPatterns("/notice/**")
					//Interceptor를 제외할 URL 등록
					.excludePathPatterns("qna/detail")
					.excludePathPatterns("qna/write");
			
			//추가 interceptor 등록
			registry.addInterceptor(studyInterceptor)
					.addPathPatterns("/qna/**");
			
			registry.addInterceptor(localeChangeInterceptor)
					.addPathPatterns("/**");
	
		}
	
}
