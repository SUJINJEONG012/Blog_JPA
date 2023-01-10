package com.mysite.project.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.model.Board;
import com.mysite.project.repository.BoardRepository;

@RestController
public class ReplyController {
 @Autowired
 private BoardRepository boardRepository;
	
 
 @GetMapping("/test/board/{id}")
 public Board getBoard(@PathVariable int id) {
	 return boardRepository.findById(id).get();
	 // jackson라이브러리 (오브젝트를 json으로리턴 ) =>모델의 getter를 호출
 }
}
