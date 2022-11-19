package com.mysite.project.dto;

import java.sql.Timestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.mysite.project.model.RoleType;
import com.mysite.project.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	

	//@Builder
	public UserDto(int id, String username, String password, String email,Timestamp createDate) {
		this.id=id;
	    this.username=username;
	    this.password=password;
	    this.email=email;
	    this.createDate=createDate;
	}
	
	
	//toEntity()메서드를 통해 Service > Database(Entity)로 Data를 전달할 때 Dto를 통해서 전달
	public  User toEntity() {
		User user = User.builder()
				.id(id)
				.username(username)
				.password(password)
				.email(email)
				.createDate(createDate)
				.build();
		return user;
	}
	
	
	

}
