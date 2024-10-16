package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain( HttpSecurity http) throws Exception  {
		
		log.info("### SecurityFilterChain =============================> ");
		
		http
	        .authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) // 어떤 요청에도 모조건 요청을 받도록
		 	//.formLogin(Customizer.withDefaults()); // 폼 로그인 방식으로 인증받겠다.
			.formLogin(form -> form
								//.loginPage("/loginPage") //Customizing은 했지만 폼은 React에서 만들 거라서 Security가 제공하는 거 쓰자
								.loginProcessingUrl("/loginProc")	// form 입력값과 DB의 값 비교해서 로그인하는 로직 Controller
								.usernameParameter("userId")	//security 에서는 username이라고 한다.
								.passwordParameter("userPass")
								//.defaultSuccessUrl("/", false) // 기본이 false, true는 항상 사용한다는 것이다. successHandler 로 대체한다.
								//.failureForwardUrl("/failed")
								
								.successHandler( (request, response, authentication) ->{
									response.sendRedirect("/home"); // 성공하면 home으로 ..
								})
								.failureHandler( (request, response, exception) ->{
									response.sendRedirect("/login"); //실패하면 login으로 
								})
								.permitAll()
								
			);
		 
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		log.info("### UserDetailsService ============================>");
		
		UserDetails user = User.withUsername("kosta")	//security 에서는 username이라고 한다
								.password("{noop}7777")
								.roles("USER") // ROLE_ 가 자동으로 붙는다. ROLE_USER cannot start with ROLE_ (it is automatically added)
								.build();
		
		log.info("### UserDetailsService ============================> user :: {}", user);
		
		return new InMemoryUserDetailsManager(user);
		
	}
	
	
}
