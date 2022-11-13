package com.iu.home.member.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.iu.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogoutSuccessCustom implements LogoutSuccessHandler{
	
	@Override
		public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
				throws IOException, ServletException {
			log.info("==== Logout 성공시에만 실행 ====");
			response.sendRedirect("/");
			
			MemberVO memberVO = (MemberVO) authentication.getPrincipal(); //memberVO
			String social = memberVO.getSocial();
			
			if(social != null) {
				if(social.equals("kakao")) {
						response.sendRedirect("https://developers.kakao.com/logout");
						RestTemplate restTemplate = new RestTemplate();
						// header X
						// parameter X
						restTemplate.getForEntity("https://developers.kakao.com/logout",null,String.class);
						
				}else if(social.equals("google")) {
					
				}else {
					
				}
			}
		}
	
}
