package com.mysite.project.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysite.project.config.auth.PrincipalDetail;

//인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
//주소가 / 인 주소를 index.jsp 허용
//static 아래에 있는 /js/**, /css/**, /images/**

@Controller
public class UserController {
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "/user/join";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "/user/login";
	}
	//수정하기 
	@GetMapping("/user/mypage")
	public String myPage(@AuthenticationPrincipal PrincipalDetail principalDetail) {
		return "/user/mypage";
	}
	
	
}
