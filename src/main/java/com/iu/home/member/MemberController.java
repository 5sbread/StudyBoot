package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
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
	@GetMapping("idCheck")
	@ResponseBody
	public int getIdCheck (MemberVO memberVO) throws Exception{
		int result = memberService.getIdCheck(memberVO);
		
		//에러 발생 테스트
//		if(result==0) {
//			throw new Exception("아아테스트테스트");
//		}
		
		return result;
	}
	
// 테스트용 -------------------------------		
	@PostMapping("test")
	@ResponseBody
	public MemberVO setTest(MemberVO memberVO, String [] ar)throws Exception{
		log.info("----------------------");
		log.info("id : {}", memberVO.getId());
		log.info("name : {}", memberVO.getName());
		log.info("ar : {}", ar);
		return memberVO;
	}
	
	
	
	
	
	
}
