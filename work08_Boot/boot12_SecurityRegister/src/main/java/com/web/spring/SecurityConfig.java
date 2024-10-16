package com.web.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//내 프로젝트 방향에 맞게 인증 방식과 인가정책을 지정한다.
		log.info("######### SecurityFilterChain ==========================>");
		
		/* 안쓰는 것 비활성화 */	
		http.csrf((auth) -> auth.disable())
			.formLogin((auth) -> auth.disable())
			.httpBasic((auth) -> auth.disable()); 
		
		
		/* 경로 별 인가 작업 */
		http.authorizeHttpRequests((auth) -> auth
								.requestMatchers("/index", "/members", "/members/**", "/boards").permitAll() 
								.requestMatchers("/admin").hasRole("ADMIN")
								.anyRequest().authenticated()); 
		
		return http.build();
	}
	
	
	//암호화하는 빈을 생성하자
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		log.info("######### BCryptPasswordEncoder call ==============================> ");
		
		return new BCryptPasswordEncoder();
	}
	

}
