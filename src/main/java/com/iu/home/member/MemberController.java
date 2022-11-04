package com.iu.home.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
// 회원가입 -------------------------------	
	@GetMapping("join")
	public void setAdd (@ModelAttribute MemberVO memberVO) throws Exception{
		
	}
	
	@PostMapping("join")
	public ModelAndView setAdd(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv)throws Exception{	
		if(bindingResult.hasErrors()) {
			//검증에 실패하면 회원가입하는 jsp로 foward
			mv.setViewName("member/join");
			return mv;
		}
		boolean check = memberService.getMemberError(memberVO, bindingResult);
		if(check) {
			log.info("===== 검증 에러 발생 ====");
			mv.setViewName("member/add");
		//-------------------------------------------
			List<FieldError > errors = bindingResult.getFieldErrors();
			
			for(FieldError fieldError:errors) {
				log.info("FieldError => {}", fieldError);
				log.info("Field = {}", fieldError.getField());
				log.info("Message => {}", fieldError.getRejectedValue());
				log.info("Default => {}", fieldError.getDefaultMessage());
				log.info("Code => {}", fieldError.getCode());
				mv.addObject(fieldError.getField(), fieldError.getDefaultMessage());
			}
		}
		//int result = memberService.setAdd(memberVO); 
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
// 로그인 -------------------------------	
	@GetMapping("login")
						// 안넘어오면 안담음					Boolean은 null값 오류 X
	public void getLogin (@RequestParam(required = false) boolean error, String message, Model model) throws Exception{
		// 로그인 실패했을 때 주소창에 파라미터 추가
		// Controller에서 받아서 jsp로 다시 보내도 됨
		
		if (error) {
			model.addAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
	}
	
	// Spring Security 사용해서 주석 처리
//	@PostMapping("login")	//로그인한 사람을 기억하기 위해 | 연결 유지를 위해 session 사용
//	public String getLogin (MemberVO memberVO, HttpSession session) throws Exception{
//		memberVO = memberService.getLogin(memberVO);
//		session.setAttribute("member", memberVO);
//		
//		return "redirect:../";
//	}
	
// 로그아웃 -------------------------------	
	public String getLogout (HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
// 아이디 체크 -------------------------------	
	@GetMapping("idCheck")
	@ResponseBody
	public Integer getIdCheck (MemberVO memberVO) throws Exception{
		return memberService.getIdCheck(memberVO);
		
//		int result = 0;
//		memberVO == null;
//		if (memberVO != null) {
//			return 1;
//		}else {
//			return 0;
//		}
	}

	
// My Page -------------------------------		
	@GetMapping("myPage")
	public void getMyPage () throws Exception {
		
	}
	
	
	
	
	
	
	
}
