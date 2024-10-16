package com.web.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IndexController {

	
	//인증을 거치치 않고 무조건 호출되는 것
	@GetMapping("/index")
	public String index() {
		
		log.info("######### IndexContoller call...");
		
		return "Spring Security Index...";
	}
	
	
	
	
}
