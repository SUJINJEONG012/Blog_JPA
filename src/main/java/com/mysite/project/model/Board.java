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
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable= false, length=100)
	private String title;
	
	@Lob //대용량데이터
	private String content; //썸머노트라이브러리 <>
	
	@ColumnDefault("0")
	private int count; //조회수
	
	
	//누가 적었는지 알아야 되니까
	private int userId;
	
	@CreationTimestamp
	private Timestamp createDate;
}
