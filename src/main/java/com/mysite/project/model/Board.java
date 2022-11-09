package com.mysite.project.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 100)
	private String title;

	@Lob // 대용량데이터
	private String content; // 썸머노트라이브러리 <>

	@ColumnDefault("0")
	private int count; // 조회수

	// 누가 적었는지 알아야 되니까
	// ORM에선 userObject를 바로 넣음
	private int userId; // DB는 오브젝트를 저장 할 수 없다.FK는 자바는 오브젝트를 저장할 수 없다.

	
	
	
	@CreationTimestamp
	private Timestamp createDate;
}
