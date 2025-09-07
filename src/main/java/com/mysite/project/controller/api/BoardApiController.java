package com.mysite.project.controller.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.project.config.auth.PrincipalDetail;
import com.mysite.project.dto.ReplySaveRequestDto;
import com.mysite.project.dto.ResponseDto;
import com.mysite.project.model.Board;
import com.mysite.project.service.BoardService;
import com.mysite.project.service.FileService;


@RestController
public class BoardApiController {
 

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private FileService fileService; // 파일 업로드 서비스
	
	
	//@RequestBody는 JSON 본문을 객체로 매핑하는 용도, 지금작업은 파일(바이너리)를 multipart/form-data로 받으려고 해서 null로 나오는거 수정
	//글쓰기 
//	@PostMapping("/api/board")
//	public ResponseDto<Integer> save(@RequestBody BoardDto boardDto , @AuthenticationPrincipal PrincipalDetail principal) throws IllegalStateException, IOException{ //title,conten{
//		boardService.saveForm(boardDto, principal.getUser());	
//		return new ResponseDto<Integer> (HttpStatus.OK.value(),1);
//	}
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(
	        @RequestParam("title") String title,
	        @RequestParam("content") String content,
	        @RequestParam(value = "file", required = false) MultipartFile file,
	        @AuthenticationPrincipal PrincipalDetail principal) throws IOException {

		System.out.println("=== [BoardController.save()] ===");
	    System.out.println("title = " + title);
	    System.out.println("content = " + content);
	    System.out.println("file = " + (file != null ? file.getOriginalFilename() : "첨부 없음"));
	    System.out.println("user = " + principal.getUser().getUsername());

	    
	    boardService.saveForm(title, content, file, principal.getUser());
	    return new ResponseDto<>(HttpStatus.OK.value(), 1);
	}
	


	//글 수정 
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> updateForm(@PathVariable int id, @RequestBody Board board){
		boardService.updateForm(id,board);
		return new ResponseDto<Integer> (HttpStatus.OK.value(),1);
	}
	
	//글 삭제
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id) {
		boardService.boardDelete(id);
		System.out.println("@@@ 삭제 아이디 : " + id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	//댓글 등록
	/*
	 * 데이터를 받을 때 컨트롤러에서 Dto를 만들어서 받아야되는데,
	 * 
	 * */
	
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto ){	
		boardService.replyForm(replySaveRequestDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
		boardService.replyDelete(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
}
