package com.iu.home.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Data;

@Data
public class MemberVO implements UserDetails, OAuth2User {
	
	@NotBlank(message = "ID 필수 입력!")
	private String id;
	
	@NotBlank
	private String pw;
	private String pwCheck;
	
	@NotBlank
	private String name;
	
	@Email
	@NotBlank
	private String email;
	
	private boolean enabled;
	
	
	@Range(max=150, min = 0)
	private int age;
	
	@Past
	private Date birth;

	private List<MemberRoleVO> memberRoleVOs;

	//===== Social Login ==========================================
	// 소셜로그인하는 회사 명 : Kakao, Naver, Google
	private String social;
	
	//OAuth2User, Token 등 정보 저장
	private Map<String, Object> attributes;

	
	
	//==== Security ===============================================
	@Override
	// ? : any를 뜻함 | extends GrantedAuthority를 상속받는 아무 타입이면 ok
	// <? super T> T나 T의 부모타입 허용
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities= new ArrayList<>();
		for(MemberRoleVO memberRoleVO : memberRoleVOs) {
			
			//SimpleGrantedAuthority : 객체 생성 후 안에 String 타입의 Role을 넣음
			//authorities.add : List에 데이터 추가
			authorities.add(new SimpleGrantedAuthority(memberRoleVO.getRoleName()));
		}
		return authorities;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pw;
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// 계정 만료 여부
		// true : 만료 X
		// false : 만료, 로그인 불가
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠김 여부
		// true  : 계정 잠기지 않음
		// false : 계정 잠김, 로그인 불가
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// 비번 만료 여부
		return true;
	}
	
	
	// 계정 사용 여부
	// true : 계정 활성화
	// false : 계정 비활성화
	public boolean isEnabled() {
		return true;
	}
	
	
	public Map<String, Object> getAttribute() {
		// TODO Auto-generated method stub
		return this.attributes;
	}

}
