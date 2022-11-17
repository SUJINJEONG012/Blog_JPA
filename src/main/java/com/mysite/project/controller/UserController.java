package com.mysite.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/user/joinForm")
	public String joinForm() {
		return "/user/join";
	}
	
	@GetMapping("/user/loginForm")
	public String loginForm() {
		return "/user/login";
	}
}
