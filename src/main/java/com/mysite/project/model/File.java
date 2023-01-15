package com.mysite.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class File {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String originFileName;
	@Column(nullable = false)
	private String fullPath;
	
	@Builder
    public File(Long id, String originFileName, String fullPath) {
        this.id = id;
        this.originFileName = originFileName;
        this.fullPath = fullPath;
    }
}
