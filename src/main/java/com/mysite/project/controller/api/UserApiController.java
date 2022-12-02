package com.mysite.project.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mysite.project.dto.ResponseDto;
import com.mysite.project.dto.UserDto;
import com.mysite.project.model.RoleType;
import com.mysite.project.model.User;
import com.mysite.project.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	@Autowired
	private UserService userService;

	
	@PostMapping("auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody UserDto userDto){
		
		userService.join(userDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	//회원수정
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){
		System.out.println("api controller user : " );
		System.out.print( "user : : @@@ :::" + user);
		userService.회원수정(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
	
	
	
//전통적인로그인	
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