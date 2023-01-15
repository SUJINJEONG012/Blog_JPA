package com.mysite.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.project.dto.FileDto;
import com.mysite.project.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileService {

	 private final FileRepository fileRepository;
	 
	 @Transactional
	    public Long save(FileDto fileDto) {
	        return fileRepository.save(fileDto.toEntity()).getId();
	    }
	 
}
