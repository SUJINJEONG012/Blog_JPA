package com.mysite.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysite.project.service.BoardService;

@Controller
public class MainController {
	
	@Autowired
	BoardService boardService;
	

	@GetMapping(value="/")
	//게시판 목록 갈때 데이터를 가져가야한다.
	public String list(Model model,@PageableDefault(size=5, sort="id", direction=Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.boardList(pageable));
		return "index"; //viewResolver 작동 
	}
	

	
	
}
