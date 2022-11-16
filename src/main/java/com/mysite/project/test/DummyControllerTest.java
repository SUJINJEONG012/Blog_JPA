package com.mysite.project.test;



import java.util.List;
import java.util.function.Supplier;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.model.RoleType;
import com.mysite.project.model.User;
import com.mysite.project.repository.UserRepository;


@RestController
//@DynamicInsert //insert시 null인 애를삭제해줌 

public class DummyControllerTest {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id) {
		
	}
	
	
	@GetMapping("/dummy/user")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	
	@GetMapping("/dummy/user/page")
	public Page<User> pageList(@PageableDefault(size=2, sort="id", direction=Sort.Direction.DESC) Pageable pageable){
		Page<User> users = userRepository.findAll(pageable);
		return users;
	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>(){
			@Override 
			public IllegalArgumentException get() {
			return new IllegalArgumentException("해당 사용자 없습니다. " + id);
			}
		});
		return user;
	}
	
	
	
	
	@PostMapping("/dummy/join")
	public String join(User user) {
	
	 System.out.println("username : " + user.getUsername());
	 System.out.println("password : " + user.getPassword());
	 System.out.println("password : " + user.getEmail());

	 user.setRole(RoleType.USER);
	 userRepository.save(user);
     return "회원가입이 완료되었습니다";	
	
	}
	
}
