package com.mysite.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



//빈등록 :  스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration //빈 등록(Ioc관리)
@EnableWebSecurity //시큐리티에 필터가 등록이 된다. 설정은 아래에서 하면된다.
@EnableGlobalMethodSecurity(prePostEnabled=true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다.

//@ConditionalOnDefaultWebSecurity
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)

public class SecurityConfig   {
 
	
	/*
	 * encodePWD() 를 호출하면 new BCryptPasswordEncoder() 객체를 리턴받을 수 있다.
	 * */
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		 String encPassword = new BCryptPasswordEncoder().encode("1234");
		 return new BCryptPasswordEncoder(); //스프링이관리 , 필요할때마다 가져다가 사용하면 된다.
	 }
	 
	 
     @Bean	
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          
	        http
	        .csrf().disable()//csrf 토큰 비활성화 (테스트시걸어두는게 좋음)
	        
	        .authorizeRequests()
	        .antMatchers("/","/auth/**","/js/**","/css/**", "/images/**").permitAll()
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
