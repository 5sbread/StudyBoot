package com.iu.home.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

// 로그인 ----------------------------------
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
// 회원가입 ----------------------------------	
	public int setJoin(MemberVO memberVO) throws Exception{
		int result = memberMapper.setJoin(memberVO);
		
		if (result<1) {
			//문제가 될 여지가 있으면 강제로 예외 발생 -> 롤백
			throw new Exception();
		}
		result = memberMapper.setRole(memberVO);
		
		if (result<1) {
			throw new Exception();
		}	
		return result;
	}
	

// 아이디 중복확인 ----------------------------------
	public int getIdCheck(MemberVO memberVO) throws Exception{
		return memberMapper.getIdCheck(memberVO);
	}
	
	
// 사용자 정의 검증 메서드 ----------------------------------	  	//에러 메세지 담기
	public boolean getMemberError (MemberVO memberVO, BindingResult bindingResult) throws Exception{
		boolean check = false;
		//check = false : 검증 성공 (error 없음)
		//check = true : 검증 실패 (eror 있음)
		
		//1. annotation 검증
		check = bindingResult.hasErrors();
		
		
		//2. password가 일치하는지 검증
		if (!memberVO.getPw().equals(memberVO.getPwCheck())) {
			check = true;
			
			//error message
			//bindingResult.rejectValue("멤버변수명(path)", "properties key");
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
		}
		
		//3. id가 중복인지 검증
		int result = memberMapper.getIdCheck(memberVO);
		if (result>0) {
			check=true;
			bindingResult.rejectValue("idCheck", "member.id.equal");
		}
		
			return check;	
	}

// ----------------------------------	        
	public int setRole(MemberVO memberVO) throws Exception{
		return memberMapper.setRole(memberVO); 
	}
}
