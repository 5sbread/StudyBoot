package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
// 회원가입 -------------------------------	
	@GetMapping("join")
	public void setAdd () throws Exception{
		
	}
	
	@PostMapping("join")
	public String setAdd (MemberVO memberVO) throws Exception{
		int result = memberService.setJoin(memberVO);
		return "redirect:../";
	}
	
// 로그인 -------------------------------	
	@GetMapping("login")
	public void getLogin () throws Exception{
		
	}
	
	@PostMapping("login")	//로그인한 사람을 기억하기 위해 | 연결 유지를 위해 session 사용
	public String getLogin (MemberVO memberVO, HttpSession session) throws Exception{
		memberVO = memberService.getLogin(memberVO);
		session.setAttribute("member", memberVO);
		
		return "redirect:../";
	}
	
// 로그아웃 -------------------------------	
	public String getLogout (HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
// 아이디 체크 -------------------------------	
	public int getIdCheck () throws Exception{
		if ( == ) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	
	
	
	
	
	
	
}
