package com.mysite.project.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//응답할 때 사용
public class ResponseDto<T> {
	int status;
	T data;
	
}
