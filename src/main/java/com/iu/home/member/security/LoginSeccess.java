package com.iu.home.member.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSeccess implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		log.info("==== 로그인 성공 ====");
		log.info("Auth => {}", authentication);
		log.info("ID : {}", request.getParameter("id"));
		
		// 파라미터를 처음 받을 때는 무조건 String
		String check = request.getParameter("rememberId");
		log.info(check);
		// 체크했을 때 -> on
		// 체크 안했을 때 -> null
		
		// 아이디 기억하기를 체크했을 떄
		// -> 쿠키 기억하기
		if(check!=null && check.equals("on")) {
			Cookie cookie = new Cookie("userId", request.getParameter("id"));
			cookie.setMaxAge(60);	// 초
			cookie.setPath("/");	// 같은 도메인 내에서 어느 URL에서 사용 가능한가 적용
			
			response.addCookie(cookie);			
		} else {
			Cookie [] cookies = request.getCookies();
			
			// 여러 쿠키 중에 이름이 rememberId인 것을 찾아야 함
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("userId")) {
					cookie.setMaxAge(0);	// 기간 만료 -> 사용 불가
					cookie.setPath("/");	// 쿠키 만들 때의 path와 동일해야 지울 수 있음
					response.addCookie(cookie);
				}
			}
		}
		
		response.sendRedirect("/");
	}
	

	
}
