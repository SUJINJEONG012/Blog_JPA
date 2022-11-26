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
	
	
//전통적인 로그인 방식	
//	@Transactional(readOnly=true)
//	public User login(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
	
	
	
	
	
	
	
	
	
	
	
}
