package com.mysite.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.project.dto.UserDto;
import com.mysite.project.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	//select* from user where username = 1?
	Optional<User> findByUsername(String username);

}


//전통적인로그인방식
//User findByUsernameAndPassword(String username, String password);

//@Query(value="")
//User login()