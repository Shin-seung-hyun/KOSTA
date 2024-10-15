package com.web.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		
		//System.out.println("index()... call");
		
		//sysout 말고 이제는 이렇게 쓰자
		log.info("index()... call");
		
		return "INDEX ..";
	}
	
}
