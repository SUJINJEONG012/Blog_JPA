package com.mysite.project.controller;



import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.project.config.auth.PrincipalDetail;
import com.mysite.project.config.auth.PrincipalDetailService;
import com.mysite.project.dto.UserDto;
import com.mysite.project.model.KakaoProfile;
import com.mysite.project.model.OAuthToken;
import com.mysite.project.model.User;
import com.mysite.project.model.User.UserBuilder;
import com.mysite.project.service.UserService;

//인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
//주소가 / 인 주소를 index.jsp 허용
//static 아래에 있는 /js/**, /css/**, /images/**

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	//생성자 주입
	@Autowired
	private  PrincipalDetailService principalDetailService;

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "/user/join";
	}

	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "/user/login";
	}

	@GetMapping("/auth/kakao/callback")
	public String kakaoCallBack(String code) {

		// POST방식으로 key=value 데이터를 요청 (카카오쪽으로)
		// Retrofit2
		// OkHttp
		// RestTemplate

		RestTemplate rt = new RestTemplate();
		
		// HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "c90bfc7a8183f140bc7ddd9aa5ac4134");
		params.add("redirect_uri", "http://localhost:8010/auth/kakao/callback");
		params.add("code", code);

		// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token",  // 토큰발급주소
				HttpMethod.POST,
				kakaoTokenRequest, 
				String.class
		);
		
		
		//Gson, Json Simple, ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oauthToken = null;
		
		try {
			 oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("카카오 액세스 토큰 : " + oauthToken.getAccess_token());
		
		
		
		RestTemplate rt2 = new RestTemplate();
		
		// HttpHeader 오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer "+oauthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = new HttpEntity<>(headers2);

		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
		ResponseEntity<String> response2 = rt2.exchange(
				"https://kapi.kakao.com/v2/user/me",  // 토큰발급주소
				HttpMethod.POST,
				kakaoProfileRequest2, 
				String.class		
	    );
	
		System.out.println(response2.getBody());
		
		
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		try {
			kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//User 오브젝트 : username, password, email
		System.out.println(" 카카오아이디(번호) : "+kakaoProfile.getId());
		System.out.println(" 카카오 이메일 :" + kakaoProfile.getKakao_account().getEmail());
		System.out.println(" 블로그서버 유저네임 : " + kakaoProfile.getKakao_account().getEmail()+ "_" + kakaoProfile.getId());
		System.out.println(" 블로그서버 이메일 : " + kakaoProfile.getKakao_account().getEmail()+ "_" + kakaoProfile.getId());
	    
		//UUID 란 :중복되지 않는 어떤특정값을 만들어내는 알고리즘
		UUID garbagePassword = UUID.randomUUID(); //랜덤값 
	    System.out.println(" 블로그서버 비밀번호 : " + garbagePassword);
		
	    
	    User kakaoUser = User.builder()
	    		.username(kakaoProfile.getKakao_account().getEmail()+ "_" + kakaoProfile.getId())
	    		.password(garbagePassword.toString())
	    		.email(kakaoProfile.getKakao_account().getEmail())
	    		//.oauth("kakao")
	            .build();
   
	    
	     //가입자 혹은 비가입자 체크 해서 처리
	 		User originUser = userService.findUser(kakaoUser.getUsername());
	 		
	 		if(originUser.getUsername() == null) {
	 			System.out.println("기존 회원이 아니기에 자동 회원가입을 진행합니다");
	 			System.out.println(kakaoUser.getUsername());
	 			userService.findUser(kakaoUser.getUsername());
	 			
	 		}
	 		
	 		System.out.println("자동 로그인을 진행합니다.");
	 		// 로그인 처리
	 		//자동로그인 진행
	 		UserDetails userDetail = principalDetailService.loadUserByUsername(kakaoUser.getUsername());
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			
			  
	   return "redirect:/"; 
		
	}

	// 수정하기
	@GetMapping("/user/mypage")
	public String myPage(@AuthenticationPrincipal PrincipalDetail principal) {
		return "/user/mypage";
	}

}
