package com.mysite.project.dto;

import java.sql.Timestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.mysite.project.model.RoleType;
import com.mysite.project.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private int id; // 오라클은 시퀀스,mysql은 auto-increment
	private String username;
	private String password;
	private String email;

	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다.

	private Timestamp createDate;

	public static UserDto toEntity(User user) {
		return UserDto.builder().id(user.getId()).username(user.getUsername()).password(user.getPassword())
				.email(user.getEmail()).createDate(user.getCreateDate()).build();

	}
	
	
	

}
