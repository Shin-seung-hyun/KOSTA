package com.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/*
 * SSR 방식을 컨트롤러
 * 결과 페이지를 JSP 사용하고,
 * 결과 페이지를 서버 사이드에서 생성해서 클라이언트 사이드로 리턴한다.
 * 
 * 1. Boot 기반은 JSP를 지원하지 않기에 JSP를 사용하려면 pom.xml에 디펜던시를 별도로 추가해야 한다.
 * 2. application.properties 파일에 InternalResourceViewResolver 빈 정보를 설정해야 한다.
 *  
 * 
 */

@Controller
public class indexController {

	@GetMapping("index")
	public String home(Model model) {
		
		System.out.println("IndexController ... home() call");
		
		model.addAttribute("message", "Hello SpringBoot!!");
		return "Result";
		
	}
	
}
