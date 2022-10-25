package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

// ----------------------------------
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
// ----------------------------------	
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
	
// ----------------------------------	
	public int setRole(MemberVO memberVO) throws Exception{
		return memberMapper.setRole(memberVO);
		 
	}
}
