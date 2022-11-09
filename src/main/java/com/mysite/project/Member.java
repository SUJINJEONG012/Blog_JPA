package com.mysite.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
@AllArgsConstructor //생성자 만들어주는 final 로 적어줘야함
@NoArgsConstructor
//@Getter
//@Setter
public class Member {
	//불변성유지하기위해 final
	private int id;
	private String username;
	private String password;
	private String email;
	
	
/*
 * 변수를 private로 만드는 이유 
 *
 * 변수에 바로 접근하지 못하게 객체지향이랑 맞지않아서,
 * 메서드로 접근할 수 있도록, 예) member.age() 이런식으로
 * private 변수의 상태를 수정(상태값변경)할 수있게 getter,setter 를 만들어야함 즉,set()로 접근할 수 있게 만들어야함
 * 
 * private로 만들지않으면 변수의 값을 다이렉트로 변경이 가능하기 때문에
 * 변수에 값을 바로 수정하는건 안됌 => 메서드로 증가를 시키던지 변경해야 함
 *
 * */	

}
