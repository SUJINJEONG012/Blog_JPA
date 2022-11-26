package com.mysite.project.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysite.project.model.User;
import com.mysite.project.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
    
	@Autowired
	private UserRepository userRepository;
	
	
	//스프링이 로그인요청을 가로챌때, usernname,password변수 2개를 가로채는데
	//password 부분처리는 알아서함.
	//username이 db에 있는지만 확인하면 됨
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("@@@@@@@@@@@@@ PrincipalDetailService :: " );
		
		User principal= userRepository.findByUsername(username).orElseThrow(()-> {
					System.out.println("@@@@userRepository ");	
			return new UsernameNotFoundException("해당사용자를 찾을 수 없습니다. " + username);
		});
		
		System.out.println("principal ::: " + principal);
		return new PrincipalDetail(principal); //시큐리티세션에 유저정보가 저장이 됨
	}
}
