package com.iu.home.member;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotBlank
	private String id;
	@NotBlank
	@Size(max=10, min=2)
	private String pw;
	private String pwCheck;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	private boolean enabled;
	
	
	@Range(max=150, min = 1)
	private int age;
	
	private Date birth;

	private List<RoleVO> roleVOs;

}
