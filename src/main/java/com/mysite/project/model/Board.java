package com.mysite.project.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 100)
	private String title;

	@Lob // 대용량데이터
	private String content; // 썸머노트라이브러리
	
	private int count; // 조회수

	
	/*
	 * 누가 적었는지 알아야 되니까,user를 불러와야
	 * ORM에선 userObject를 바로 넣음
	 * 필드는 userId 만들어지고
	 * */
	// board => many, user => one //한명의 유저는 여러개의 게시물을 쓸 수 있다.
	
	
	
	@ManyToOne(fetch= FetchType.EAGER) //기본전략
	@JoinColumn(name="userId")
	private User user; 
	// DB는 오브젝트를 저장 할 수 없다.FK는 자바는 오브젝트를 저장할 수 없다.

	@OneToMany(mappedBy="board", fetch=FetchType.EAGER) //mappedBy연관관계의 주인이 아니다(FK키가아니에요). db에컬럼을 만들지마세요.
	//join칼럼은 안들어가고 =>데이터베이스는 원자성 때문에 하나의 값만들어가야되는데, 여러개의 댓글이 달릴수도 있으니 !
	private List<Reply> reply; 
	
	@CreationTimestamp
	private Timestamp createDate;
	
}
