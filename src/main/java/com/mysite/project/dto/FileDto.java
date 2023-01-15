package com.mysite.project.dto;



import com.mysite.project.model.File;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FileDto {

	private Long id;
	private String originFileName;
	private String fullPath;

	public File toEntity() {
		return File.builder()
				.id(this.id)
				.originFileName(this.originFileName)
				.fullPath(this.fullPath)
				.build();
	}

	@Builder
	public FileDto(Long id, String originFileName, String fullPath) {
		this.id = id;
		this.originFileName = originFileName;
		this.fullPath = fullPath;
	}

}
