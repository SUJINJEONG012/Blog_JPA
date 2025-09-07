package com.mysite.project.service;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private final String uploadDirectory = "/Users/jeongsujin/upload/";

    public String uploadFile(MultipartFile file) {
        try {
            Path filePath = Paths.get(uploadDirectory + file.getOriginalFilename());
            file.transferTo(filePath);
            return filePath.toString();  // 파일 경로를 반환
        } catch (Exception e) {
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }
}

