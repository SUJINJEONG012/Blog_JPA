package com.mysite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.project.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply,Integer> {

}
