package com.iu.home.member.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginFail implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		log.info("==== Login Fail ====");
		log.info("LocalMessage => {}", exception.getLocalizedMessage());
		log.info("Cause => {}", exception.getCause());
		log.info("Message => {}", exception.getMessage());
		
		// 방법 1
//		String name = exception.getClass().toString();
//		name = name.substring(name.lastIndexOf("."));
//		if(name.equals(".BadCredentailException")) {
//			name = "HEY!";
//		}		
//		name = URLEncoder.encode(name, "UTF-8");
		
		
		// 방법 2
		String result = null;
		//참조변수명 instance of 클래스명
		if (exception instanceof BadCredentialsException) {
			result = "PW_ERROR";
		}else if(exception instanceof InternalAuthenticationServiceException) {
			result="ID_ERROR";
		}else {
			result="LOGIN_FAIL";
		}
		
		//redirect
		response.sendRedirect("/member/login?error=true&message="+result);
		
		// 방법 2 | JSP를 바로 찾아감
		//request.setAttribute("msg", result);
		//request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
		
		// 방법 3 | POST 방식으로 Controller의 메서드 요청함
		//request.getRequestDispatcher("/member/login").forward(request, response);
	}
	
}
