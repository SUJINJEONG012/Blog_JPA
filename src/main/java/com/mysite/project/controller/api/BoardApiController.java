package com.mysite.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.config.auth.PrincipalDetail;
import com.mysite.project.dto.BoardDto;
import com.mysite.project.dto.ResponseDto;
import com.mysite.project.model.Board;
import com.mysite.project.service.BoardService;

@RestController
public class BoardApiController {
 
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody BoardDto boardDto, @AuthenticationPrincipal PrincipalDetail principal ){
		boardService.saveForm(boardDto, principal.getUser());
		return new ResponseDto<Integer> (HttpStatus.OK.value(),1);
	}
	
}
