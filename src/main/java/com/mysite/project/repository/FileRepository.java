package com.mysite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.project.model.File;

public interface FileRepository extends JpaRepository<File, Long> {}
