package com.mysite.project.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mysite.project.model.Board;
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
public class BoardDto {

	private int id; 
	private String title;
	private String content;
    private Long fileId;
	private int count; // 조회수
	
	
	private Timestamp createDate;

	@ManyToOne(fetch= FetchType.EAGER) //기본전략
	@JoinColumn(name="userId")
	private User user; 

	@Builder
	public BoardDto(int id, String title, String content, Long fileId, Timestamp createDate, User user) {
		this.id=id;
	    this.title=title;
	    this.content=content;
	    this.fileId = fileId;
	    this.createDate=createDate;
	    this.user=user;
	    
	}
	
	
	//toEntity()메서드를 통해 Service > Database(Entity)로 Data를 전달할 때 Dto를 통해서 전달
	public  Board toEntity() { //save
		Board board = Board.builder()
				.id(id)
				.title(title)
				.content(content)
				.fileId(fileId)
				.createDate(createDate)
				.user(user)
				.build();
		return board;
	}
	
}
