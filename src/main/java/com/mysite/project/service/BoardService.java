package com.mysite.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.project.dto.BoardDto;
import com.mysite.project.dto.UserDto;
import com.mysite.project.model.Board;
import com.mysite.project.model.RoleType;
import com.mysite.project.model.User;
import com.mysite.project.repository.BoardRepository;
import com.mysite.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	// 생성자 주입
	private final BoardRepository boardRepository;
 
	//글쓰기
	@Transactional
	public void saveForm(BoardDto boardDto, User user) { //title,content
		boardDto.setCount(0);// 조회수 강제로 넣음
		boardDto.setUser(user);
		boardRepository.save(boardDto.toEntity());
	}

	
	
	//글 목록리스트
	@Transactional(readOnly=true)
	public Page<Board> boardList(Pageable pageable) {	
		return boardRepository.findAll(pageable);
	}
	
	//글 상세보기 
	@Transactional(readOnly=true)
	public Board boardView(int id) {
		return boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 상세보기실패: 아이디를 찾을 수 없습니다");
		});
	}
	
	//글삭제
	@Transactional
	public void boardDelete(int id) {
		boardRepository.deleteById(id);
	}
	
	
	


}
