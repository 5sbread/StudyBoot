package com.iu.home.memeber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.iu.home.member.MemberMapper;
import com.iu.home.member.MemberVO;

@SpringBootTest
class MemberServieceTest {
	
	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void test() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin1");
		
					//암호화된 비번
		memberVO.setPw(passwordEncoder.encode("admin1"));
		memberVO.setName("호호");
		memberVO.setEmail("ad@gamil.com");
		
		int result = memberMapper.setJoin(memberVO);
		assertEquals(1, result);
	}

}
