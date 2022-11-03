package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Mapper
public interface MemberMapper {

						//String 타입 | 매개변수 명 : username
	public MemberVO getLogin(String username) throws UsernameNotFoundException;
	
	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setRole(MemberVO memberVO) throws Exception;
	
	public Integer getIdCheck (MemberVO memberVO) throws Exception;
	
}
