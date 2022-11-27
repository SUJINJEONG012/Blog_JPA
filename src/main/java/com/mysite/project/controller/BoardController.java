package com.mysite.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysite.project.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping({"","/"})
	//메인페이지로 갈때 데이터를 가져가야한다.
	public String index(Model model) {
		model.addAttribute("boards", boardService.boardList());
		return "index"; //viewResolver 작동 
	}
	
	//USER권한 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
}
