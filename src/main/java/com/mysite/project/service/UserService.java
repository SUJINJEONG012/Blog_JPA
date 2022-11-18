package com.mysite.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.project.dto.UserDto;
import com.mysite.project.model.User;
import com.mysite.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	
	private final UserRepository userRepository;
	
	
	@Transactional
	public int 회원가입(UserDto userDto) {
		try {
			userRepository.save(user);
			return 100 ; // 리턴되는 값 json으로 값 넘겼을 때 보여지는 부분 user.js에 콘솔창 결과값나옴
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("userservice " + e.getMessage());
		}
		
		return -100;
	}
	
	
}
