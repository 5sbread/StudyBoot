package com.iu.home.member.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import com.iu.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogoutCustom implements LogoutHandler{
	
	// 로그아웃 시 할 행동
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		request.getSession().invalidate();
		log.info("==== LogOutHandler ====");
		
		// 1. 일반 로그인? | Social 로그인 사용?
		log.info("Auth : {}", authentication);
		
		request.getSession().invalidate();
	}
}
