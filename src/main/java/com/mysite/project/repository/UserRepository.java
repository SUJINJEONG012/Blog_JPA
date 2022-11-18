package com.mysite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mysite.project.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}