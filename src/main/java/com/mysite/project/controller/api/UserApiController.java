package com.mysite.project.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.config.auth.PrincipalDetailService;
import com.mysite.project.dto.ResponseDto;
import com.mysite.project.dto.UserDto;
import com.mysite.project.model.User;
import com.mysite.project.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	@Autowired
	private UserService userService;
	
	//생성자 주입
	private final PrincipalDetailService principalDetailService;
	
	@PostMapping("auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody UserDto userDto){
		
		userService.join(userDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	//회원수정
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user, HttpSession session){
//		System.out.println("api controller user : " );
//		System.out.print( "user : : @@@ :::" + user);
		userService.userUpate(user);
		
		//여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됐음.
		//하지만 세션값은변경되지 않은 상태이기 때문에 직접 세션값을 변경해줄거임

		//세션등록
		UserDetails userDetail = principalDetailService.loadUserByUsername(user.getUsername());
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		
		session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		
		
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