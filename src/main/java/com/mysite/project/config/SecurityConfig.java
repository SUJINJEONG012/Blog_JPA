package com.mysite.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration(proxyBeanMethods = false)


//빈등록 :  스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration //빈 등록(Ioc관리)
@EnableWebSecurity //시큐리티에 필터가 등록이 된다. 설정은 아래에서 하면된다.

//@EnableGlobalMethodSecurity(prePostEnabled=true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다.
//@ConditionalOnDefaultWebSecurity
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)

public class SecurityConfig  {
	
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
	    http
	      .csrf().disable()
	      .authorizeRequests()//어떤요청이 들어오면 ,
	      .antMatchers("/admin/**").hasRole("ADMIN") //누구나들어올수있다. 
	      
	      .antMatchers("/anonymous*").anonymous()
	      .antMatchers("/login*").permitAll()
	      
	      //다른 모든 요청은 인증이 되어야 돼
	      .anyRequest().authenticated()
	      .and();
	     
	}
	
	
     @Bean	
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.formLogin()
	                .loginPage("/auth/loginForm") 
	                .defaultSuccessUrl("/")
	                .usernameParameter("username");
	                
	        
	        http.authorizeRequests()
            .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
            .mvcMatchers("/", "/layout/**","/user/**", "/images/**").permitAll()
            .mvcMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated();
	        
	        
//	        http.exceptionHandling()
//            .authenticationEntryPoint(new CustomAuthenticationEntryPoint());
	        
	        return http.build();
	    }
     
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
	 
	 
}
