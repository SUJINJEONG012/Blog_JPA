package com.mysite.project.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.Member;


//사용자가 요청 => 응답 (data)
@RestController
public class HttpControllerTest {
	
	
	//http://localhost:8010/http/get (select)
//	@GetMapping("/http/get")
//	public String getTest(@RequestParam int id, @RequestParam String username) {
//		return "get 요청" + id + username;
//	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		//http://localhost:8010/http/get?id=1&username=angela&password=1234&email=peekaboo32@naver.com
		return "get 요청" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail() ;
	}
	
	
	//http://localhost:8010/http/post (insert)
	@PostMapping("/http/post")
//	public String postTest(Member m) {
//		return "post 요청" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail() ;
//	}
	public String postTest(@RequestBody Member m) { //MessageConverter
		return "post 요청" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail() ;
}
	
	
	
	//http://localhost:8010/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail() ;
	}
	//http://localhost:8010/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
