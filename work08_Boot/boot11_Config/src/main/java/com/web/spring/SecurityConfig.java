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
		http.csrf((auth) -> auth.disable()); // csrf를 비활성화, csrf 공격을 방어하기 위해 토큰 주고 받는 부분 비활성화
		
		/*
		 * 이를 해야하는 이유
		 * 1.security에서 제공하는 기본폼을 안쓰겠다.
		 * 2. React를 앞으로 활용하기 위해 필요가 없다.
		 * 3. formLogin을 disable하면 인증 시큐리티 아키텍처에서 사용 안 하는 부분이 있다.
		 * 	  AuthenticationFilter (UsernamePasswordAuthenticationFilter)을 안 쓰는 방식으로 인증방식이 변경된다.
		 * 
		 */
		http.formLogin((auth) -> auth.disable());
		
		http.httpBasic((auth) -> auth.disable()); // 클라이언트 요청을 바로 DispatcherServlet으로 보내지 않겠다.
		
		
	/* 경로 별 인가 작업 */
		http.authorizeHttpRequests((auth) -> auth
								.requestMatchers("/index", "/members", "/members/**", "/boards").permitAll() // members 뒤에 나오는 모든 요청
								.requestMatchers("/admin").hasRole("ADMIN")
								.anyRequest().authenticated()); // 앞의 내용을 제외한 다른 요청들은 인증을 거쳐서 들어와야 한다.
		
		return http.build();
	}
	
	
	//암호화하는 빈을 생성하자
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		log.info("######### BCryptPasswordEncoder call ==============================> ");
		
		return new BCryptPasswordEncoder();
	}
	
	
	

}
