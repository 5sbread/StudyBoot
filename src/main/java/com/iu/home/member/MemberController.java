package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("login")
	public void getLogin () throws Exception{
		
	}
	
	@PostMapping("login")	//로그인한 사람을 기억하기 위해 | 연결 유지를 위해 session 사용
	public String getLogin (MemberVO memberVO, HttpSession session) throws Exception{
		memberVO = MemberService.getLogin(memberVO);
		session.setAttribute("member", memberVO);
		
		return "redirect:../";
	}
	
	

}
