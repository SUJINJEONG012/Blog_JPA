package com.mysite.project.test;

import javax.persistence.Id;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//사용자가 요청 => 응답 (data)
@RestController
public class HttpControllerTest {
	

//	@GetMapping("/http/get")
//	public String getTest(@RequestParam int id, @RequestParam String username) {
//		 return "get 요청 : " +  "사용자 id : " + id + "사용자이름 : " +username;
//	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		 return "get 요청 : " +  "사용자 id : " + m.getId() + "사용자이름 : " +m.getUsername();
	}
	

	
//	@PostMapping("/http/post")
//	public String postTest(Member m) {
//		return "post 요청 : " +  "사용자 id : " + m.getId() + "사용자이름 : " +m.getUsername() + "사용자비밀번호 : " + m.getPassword()+"사용자이메일 :" +m.getEmail();
//	}

	
	@PostMapping("/http/post")//json 타입으로
	public String postTest(@RequestBody Member m) {
		return "post 요청 : " +  "사용자 id : " + m.getId() + "사용자이름 : " +m.getUsername() + "사용자비밀번호 : " + m.getPassword()+"사용자이메일 :" +m.getEmail();
	}
	
	@PutMapping("http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + " id : " + m.getId() +  ", 사용자비밀번호 : " + m.getPassword();
	}
	
//	@DeleteMapping("http/put")
//	public String putTest(@RequestBody Member m) {
//		return "put 요청 : " + " id : " + m.getId() +  ", 사용자비밀번호 : " + m.getPassword();
//	}
	
	
	
	
}
