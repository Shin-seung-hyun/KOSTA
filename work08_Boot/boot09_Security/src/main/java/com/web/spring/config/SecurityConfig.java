package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	//인증관련 설정은 SecurityFilterChain이 담당한다.
	//빈으로 만들자
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		//SecurityFilterChain을 빈으로 지정하고 여기에 http 요청에 대한 인증과 권한 관련된 인가정책을 등록하자
		//ex) members/ 요청은 인증을 해야하는지 안해도 되는지
		//7버전부터는 모든 코드를 람다식으로 작성하도록 규정하고 있다. 람다식을 연습해보자
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated()) // 어떤 요청이든  인증 받겠다. authenticated 해야 한다는 뜻
			.formLogin(Customizer.withDefaults()); // 디폴트 방식인 로그인 폼으로 인증받겠다.
		
		return http.build();
	}
	
	//UserDetailsService 빈을 등록하고 DB연결했다고 치고, id,pwd 정보를 InMemory시켜보자
	//application.properties 설정 파일에도 User 정보를 등록하고, 여기도 등록했다. 누가 우선순위가 높을까?
	//userDetailsService가 더 우선순위가 높다
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("security")
								.password("{noop}7777")
								.roles("USER")
								.build();
		
		UserDetails user1 = User.withUsername("security2")
								.password("{noop}8888")
								.roles("USER")
								.build();
		
		
		return new InMemoryUserDetailsManager(user, user1);
		
	}
	
	
}
