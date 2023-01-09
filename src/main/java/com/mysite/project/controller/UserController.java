package com.mysite.project.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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
	
	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallBack(String code) {
		
		//post방식으로 key=value 데이터를 요청(카카오한테)
		RestTemplate rt = new RestTemplate(); // 라이브러리
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers= new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		//HttpBody 오브젝트 생성
		MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "37bf2429bee5601aea377f8d3d0add90");
		params.add("redirect_uri", "http://localhost:8010/auth/kakao/callback");
		params.add("code", code);
		
		//HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
		new HttpEntity<>(params, headers);
		
		//Http 요청하기 - Post방식으로 그리고 response 변수의 응답받음. 
		ResponseEntity<String> response =rt.exchange(
	    "https://kauth.kakao.com/oauth/token",
	    HttpMethod.POST,
	    kakaoTokenRequest,
	    String.class
		);
				
		return "카카오 토큰 요청 완료 : 토큰 요청에대한 응답 :  " + response;
	}
	//수정하기 
	@GetMapping("/user/mypage")
	public String myPage(@AuthenticationPrincipal PrincipalDetail principal) {
		return "/user/mypage";
	}
	
	
}
