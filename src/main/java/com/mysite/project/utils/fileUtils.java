//package com.mysite.project.utils;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//
//
//@Component
//public class fileUtils {
//
//	private final String singuploadPath = Paths.get("/Users", "jeongsujin", "upload").toString();
//	private final String multuploadPath = Paths.get("/Users", "jeongsujin", "upload", "multupload").toString();
//
//	/**
//	 * 다중 파일 업로드
//	 * 
//	 * @param multipartFiles - 파일 객체 List
//	 * @return DB에 저장할 파일 정보 List
//	 */
//	public List<ImagemappingDto> uploadFiles(final List<MultipartFile> multipartFiles) {
//		// 여러 이미지를 담는 객체
//		List<ImagemappingDto> noticeFiles = new ArrayList<>();
//
//		for (MultipartFile multipartFile : multipartFiles) {
//			if (multipartFile.isEmpty()) {
//				continue;
//			}
//
//			noticeFiles.add(uploadFile(multipartFile));
//		}
//		return noticeFiles;
//	}
//
//	
//
//	/**
//	 * 단일 파일 업로드
//	 * 
//	 * @param multipartFile - 파일 객체
//	 * @return DB에 저장할 파일 정보
//	 */
//	public ImagemappingDto uploadFile(final MultipartFile multipartFile) {
//		if (multipartFile.isEmpty()) {
//			return null;
//		}
//		// 파일이름
//		String saveName = generateSaveFilename(multipartFile.getOriginalFilename());
//		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")).toString();
//		String uploadPath = getSingUploadPath(today) + File.separator + saveName; // 변경된 부분
//
//		// 파일위치
//		File uploadFile = new File(uploadPath);
//
//		/*
//		 * transferTo() 경우 IOException와 IllegalStateException을 일으킬 가능성이 있기 때문에 컴파일러에서
//		 * try catch문을 사용하라는 경구 문이 뜹니다. 따라서 파일을 저장하는 코드를 try catch문
//		 */
//		try {
//
//			multipartFile.transferTo(uploadFile);
//
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		return ImagemappingDto.builder().originalName(multipartFile.getOriginalFilename()).saveName(saveName)
//				.size((int) multipartFile.getSize()).build();
//	}
//
//	
//	/**
//	 * 저장 파일명 생성
//	 * 
//	 * @param filename 원본 파일명
//	 * @return 디스크에 저장할 파일명
//	 */
//	public String generateSaveFilename(final String filename) {
//		// uuid 적용 파일 이름
//		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//		String extension = StringUtils.getFilenameExtension(filename);
//		return uuid + "." + extension;
//	}
//
//	/**
//	 * 업로드 경로 반환
//	 * 
//	 * @return 업로드 경로
//	 */
//	public String getSingUploadPath() {
//		return makeDirectories(singuploadPath);
//	}
//
//	public String getMultUploadPaths() {
//		return makeDirectories(multuploadPath);
//	}
//
//	/**
//	 * 업로드 경로 반환
//	 * 
//	 * @param addPath - 추가 경로
//	 * @return 업로드 경로
//	 */
//	public String getSingUploadPath(final String addPath) {
//		return makeDirectories(singuploadPath + File.separator + addPath);
//	}
//
//	public String getMultUploadPath(final String addPath) {
//		return makeDirectories(multuploadPath + File.separator + addPath);
//	}
//
//	/**
//	 * 업로드 폴더(디렉터리) 생성
//	 * 
//	 * @param path - 업로드 경로
//	 * @return 업로드 경로 디렉토리가 존재하는지 유무를반환하는 exists()메서드를 활용하여 if문 작성
//	 */
//	private String makeDirectories(final String path) {
//		File dir = new File(path);
//		if (dir.exists() == false) {
//			dir.mkdirs();
//		}
//		return dir.getPath();
//	}
//
//	/**
//	 * 첨부파일(리소스) 조회 (as Resource), 다운로드, 출력
//	 * 
//	 * @param file - 첨부파일 상세정보
//	 * @return 첨부파일(리소스)
//	 */
//
//	// 공지사항 단일파일
//	public Resource readFileAsResource(final NoticeFileVo file) {
//
//		String uploadedDate = file.getCreatedDate().toLocalDate().format(DateTimeFormatter.ofPattern("yyMMdd"));
//		String filename = file.getSaveName();
//
//		// 절대경로 생성
//		Path filePath = Paths.get(singuploadPath, uploadedDate, filename);
//
//		try {
//			// UrlResource 객체생성 파일에 접근할 uri생성
//			Resource resource = new UrlResource(filePath.toUri());
//			if (resource.exists() == false || resource.isFile() == false) {
//				throw new RuntimeException("file not found : " + filePath.toString());
//			}
//			return resource;
//
//		} catch (MalformedURLException e) {
//			throw new RuntimeException("file not found :" + filePath.toString());
//		}
//	}
//
//	
//	// 공지사항 다중 파일
//	public Resource readFileAsResources(final NoticeFileVo files) {
//
//		String uploadedDate = files.getCreatedDate().toLocalDate().format(DateTimeFormatter.ofPattern("yyMMdd"));
//		String filename = files.getSaveName();
//
//		// 절대경로 생성
//		Path filePaths = Paths.get(multuploadPath, uploadedDate, filename);
//
//		try {
//			// UrlResource 객체생성 파일에 접근할 uri생성
//			Resource resource = new UrlResource(filePaths.toUri());
//			if (resource.exists() == false || resource.isFile() == false) {
//				throw new RuntimeException("file not found : " + filePaths.toString());
//			}
//			return resource;
//
//		} catch (MalformedURLException e) {
//			throw new RuntimeException("file not found :" + filePaths.toString());
//		}
//	}
//
//	
//	
//	// 단일 저장된 파일을 가져오는 메서드
//	public Resource loadFileAsResource(String fileName) throws MalformedURLException, FileNotFoundException {
//		Path filePath = Paths.get(singuploadPath).resolve(fileName).normalize();
//
//		Resource resource = new UrlResource(filePath.toUri());
//
//		if (resource.exists()) {
//			return resource;
//		} else {
//			throw new FileNotFoundException("파일을 찾을 수 없습니다: " + fileName);
//		}
//	}
//
//	// 다중 저장된 파일을 가져오는 메서드
//	public Resource loadFileAsResources(String fileNames) throws MalformedURLException, FileNotFoundException {
//		Path filePaths = Paths.get(multuploadPath).resolve(fileNames).normalize();
//
//		Resource resource = new UrlResource(filePaths.toUri());
//
//		if (resource.exists()) {
//			return resource;
//		} else {
//			throw new FileNotFoundException("파일을 찾을 수 없습니다: " + fileNames);
//		}
//	}
//}
