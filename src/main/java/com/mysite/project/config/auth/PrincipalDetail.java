package com.mysite.project.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mysite.project.model.User;

import lombok.Data;
import lombok.Getter;

/*
 * 
 * UserDetails 추상메서드를 들고있는데 이걸 오버라이딩 해야한다. 
 * 
 * 
 *스프링시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 
 *UserDetail타입의 오브젝트를스프링시큐리티의 고유한세션저장소에 저장을 해준다. 
 * */


@Data

public class PrincipalDetail implements UserDetails {
	
    private User user; // 객체를 품고있는거, 콤포지션	
    
    //생성자
    public PrincipalDetail(User user) {
    	this.user = user;
    }

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료되지않았는지 리턴 (true:만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있는지, 안잠겨있는지 리턴 (true:잠기지않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료되지 않았는지 리턴한다.(true:만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정활성화여부 (true:활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}

	// 계정이 갖고있는 권한 목록을 리턴한다.(권한이 여러개 있을 수 있어서 for문을 돌려야 하는데 현재는 한개만 )
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
//		collectors.add(new GrantedAuthority() {
//			@Override
//			public String getAuthority() {
//				//ROLE_이건 규칙
//				return "ROLE_" + user.getRole(); //ROLE_USER , ROLE_ADMIN
//			}
//		});
		
		//람다식으로 
		collectors.add(()->{return "ROLE_"+user.getRole();});
		return collectors;
	}
}
