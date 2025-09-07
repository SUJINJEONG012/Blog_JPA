package com.mysite.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.mysite.project.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	
	@GetMapping("/board/boardList")
	//게시판 목록 갈때 데이터를 가져가야한다.
	public String list(Model model, @PageableDefault(size=6, sort="id", direction=Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.boardList(pageable));
		return "board/list"; //viewResolver 작동 
	}

	
	//USER권한 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	//상세보기 
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model ) {
		model.addAttribute("board", boardService.boardView(id));
		return "board/detail";
	}
	
	
	//글수정하기 
	@GetMapping("/board/{id}/updateForm")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.boardView(id));
		return "board/updateForm";
	}

}
