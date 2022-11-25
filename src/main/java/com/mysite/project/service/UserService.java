package com.mysite.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.project.dto.UserDto;
import com.mysite.project.model.User;
import com.mysite.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	//생성자 주입
	private final UserRepository userRepository;
	
	@Transactional
	public void join(UserDto userDto) {
		userRepository.save(userDto.toEntity());	
	}
	
	@Transactional(readOnly=true)
	public User login(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	
	
	
	
	
	
	
	
	
	
}
