package com.mysite.project.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok .* ;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //user클래스가 자동으로 mysql 테이블 생성
public class User {
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //넘버링 
	private int id; //오라클은 시퀀스,mysql은 auto-increment
	
	//유저네임이 null값이 되면 안되기때문에
	
	@Column(nullable= false, length=30)
	private String username;
	
	@Column(nullable= false, length=200) //비밀번호 암호화(해쉬)
	private String password;
	
	@Column(nullable= false, length=200)
	private String email;
	
	
	
	//@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다.
	//어떤회원가입을했을때 ADMIN, USER, manager 권한주기(도메인설정 , 도메인은 범위를 얘기하는거 , 성별은 남,여. 고등학교 1~3학년 이런식)
	
	@CreationTimestamp //시간이 자동 입력
	private Timestamp createDate;
	
	
}
