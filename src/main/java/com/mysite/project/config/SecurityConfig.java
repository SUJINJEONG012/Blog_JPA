package com.mysite.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.mysite.project.config.auth.PrincipalDetailService;




@Configuration //빈 등록(Ioc관리)빈등록 :  스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@EnableWebSecurity //시큐리티에 필터가 등록이 된다. 설정은 아래에서 하면된다.
public class SecurityConfig{
 
	
	//생성자 주입
	private PrincipalDetailService principalDetailService;
	
	// encodePWD() 를 호출하면 new BCryptPasswordEncoder() 객체를 리턴받을 수 있다.
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		 return new BCryptPasswordEncoder(); //스프링이관리 , 필요할때마다 가져다가 사용하면 된다.
	 }
	 
	
	/*
	 * 시큐리티가 대신 로그인해주는데 password를 가로채기할때 해당 password가 뭘로 해쉬가 되어
	 * 회원가입이 되었는지 알아야, 로그인할 때 같은해쉬로 암호화해서 db에있는 해쉬랑 비교할 수있음
	 * */
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
     @Bean 
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          
	        http
	        .csrf().disable()//csrf 토큰 비활성화 (테스트시걸어두는게 좋음)
	        
	        .authorizeRequests()
	        .antMatchers("/","/board/boardList","/board/write","/auth/**","/js/**","/css/**", "/images/**").permitAll() //로그인하지않고 모두 궈한을 가짐 
            .anyRequest()
            .authenticated()
            
            .and()
            .formLogin()
            .loginPage("/auth/loginForm")
            .loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 로그인을 가로챈다.
	        .defaultSuccessUrl("/"); //정상적으로 요청이 완료
	        
	             
	        return http.build();
	    }
     	 
	 
}
