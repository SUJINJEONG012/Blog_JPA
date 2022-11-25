package com.mysite.project.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.dto.ResponseDto;
import com.mysite.project.dto.UserDto;
import com.mysite.project.model.RoleType;
import com.mysite.project.model.User;
import com.mysite.project.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	//응답 Dto insert로, json타입으로 @RequestBody로 객체넣어주고,user는 강제로 넣어주고,

	//int타입으로 변수만들어서 서비스부분에 회원가입메서드안에 user파라미터 넣어주고,
	//실행이 잘되면dto결과값 보내준다. service단에 설정한
	//try, catch문으로 예외처리로 ! 성공처리가 되서 콘솔창에
	
	@PostMapping("api/user")
	public ResponseDto<Integer> save(@RequestBody UserDto userDto){
		//System.out.println("@@@@@ UserApiController");
		userDto.setRole(RoleType.USER);
		userService.join(userDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	
	}
	
	
//	@PostMapping("api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
//		System.out.println("로그인 : @@@@");
//		User principal= userService.login(user);//principal(접근주체)
//		
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);	
//	}	
}