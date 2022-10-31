package com.iu.home.member;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	
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

	private List<RoleVO> roleVOs;

}
