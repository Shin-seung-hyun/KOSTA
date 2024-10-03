package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
	Controller를 작성하는 방법2가지
	1. Controller 인터페이스를 상속 받아서 만드는 법
	2. POJO 로 만드는 방법 (더 Advanced한 방법) 
		@ Annotation으로 한다는 뜻 : <bean> 이 부분이 생략된다는 뜻이다.

 */

@Controller
public class IndexController {
	
	@RequestMapping("/index.do")
	public ModelAndView doIndex() {
	/*
		1. 폼값 받아서
		2. DAO 리턴받고, 비즈니스 로직 호출
		3. 데이터 바인딩 --> ServletRequest에 자동 바인딩
		4. 네비게이션 --> Forwarding
		... 1~4 했다 치고,
	*/
		
		return new ModelAndView("result","info", "Plain Old Java Object~!!");
	}
}
