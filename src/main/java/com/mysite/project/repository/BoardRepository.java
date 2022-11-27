package com.mysite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mysite.project.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{	

}

