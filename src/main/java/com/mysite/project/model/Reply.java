package com.mysite.project.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
public class Reply {
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //넘버링 
	private int id;
	
	@Column(nullable=false, length=200)
	private String content;
	
	@ManyToOne //여러개의 답변은 하나의 게시글에 존재할 수 있다.
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp //시간이 자동 입력
	private Timestamp createDate;

}
