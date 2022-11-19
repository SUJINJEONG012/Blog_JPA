package com.mysite.project.test;



import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.model.RoleType;
import com.mysite.project.model.User;
import com.mysite.project.repository.UserRepository;


@RestController
//@DynamicInsert //insert시 null인 애를삭제해줌 

public class DummyControllerTest {
	
	@Autowired
	private UserRepository userRepository;

	/*
	 * save함수는 id를 전달하지 않으면 insert를 해주고,
	 * save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고,
	 * save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해요.
	 * 
	 * */
	
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
	System.out.println("id : " + id);
	System.out.println("password : " + requestUser.getPassword());
	System.out.println("email : " + requestUser.getEmail());
	
	//아이디를못찾으면 함수를 실행해라.근데 자바는 파라미터에 함수를 실행할 수 없다. => 람다식으로 넣을 수 있음 
	User user = userRepository.findById(id).orElseThrow(()->{
		return new IllegalArgumentException("수정에 실패하였습니다.");
	});
	
	
	//user.setPassword(requestUser.getPassword());
	//user.setEmail(requestUser.getEmail());
	
	//userRepository.save(user); 이걸주석하고 트랜직션을 넣으면 update가 된다. 
	//=> 더티체킹 
	return user; 
	}
	
	
	//삭제
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다.해당id는 db에 없습니다.";
		}
		return "삭제되었씁니다  id :" +id;
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
