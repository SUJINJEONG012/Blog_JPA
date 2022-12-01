package com.mysite.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.project.dto.UserDto;
import com.mysite.project.model.RoleType;
import com.mysite.project.model.User;
import com.mysite.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	//생성자 주입
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;
	
		
	@Transactional
	public void join(UserDto userDto) {
	    String rawPassword = userDto.getPassword();//1234
	    String encPassword = encoder.encode(rawPassword); //해쉬로
	    userDto.setPassword(encPassword);
		userDto.setRole(RoleType.USER);
		userRepository.save(userDto.toEntity());	
	}
	
	
	@Transactional
	public void myPageUpdate(User user) {
		/*
		 * 수정시에는 영속성 컨텍스트 User 오브젝트영속화시키고, 영속화된 User오브젝트를 수정
		 * select를 해서 User오브젝트를 DB로부터 가져오는 이유는 영속화 하기 위해
		 * 영속화된오브젝트를 변경하면 자동으로 DB에 update문을 날려주기 위해
		 * 
		 */
		
		User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원 찾기 실패");
		});
		
	    //찾았으면 여기에 오브젝트가 들어올것,
		
		//사용자로부터 비밀번호를 받는다.(패스워드를 암호화해서 넣어야된다.)
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());
		
		//회원수정 메서드가 끝날 때 = 서비스 종료시 = 트랜잭션이 종료 = commit자동 
		
	}
	
	
	
	
	
//전통적인 로그인 방식	
//	@Transactional(readOnly=true)
//	public User login(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
	
	
	
	
	
	
	
	
	
	
	
}
