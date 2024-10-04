package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.User;
import com.service.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("memberLogin.do")
	public ModelAndView login(User user, HttpServletRequest request) throws Exception{
	
		System.out.println(" getUser Before : " + user ); // name, email 은 null
		User rvo = userService.getUser(user);

		System.out.println(" getUser After : " + rvo ); // 꽉찬 rvo
		String path = "index.jsp";
		String msg = "아이디 혹은 패스워드가 틀렸습니다";
		
		if(rvo != null) { // 로그인 성공했다면 .. 세션에 바인딩
			request.getSession().setAttribute("user", rvo);
			
			msg = "성공적으로 로그인 됐습니다.";
		}
		
		request.setAttribute("msg", msg); // 로그인 성공여부에 따라서 저장되는 MSG가 달라지도록
		return new ModelAndView("redirect:" + path); 
		
		/* 
		 	forward 에서는 페이지 이동에 확장자를 넣지 않았다.
		   
		   presentationBean.xml
		   forward의 결과 페이지는 viewResovler를 무조건 참고한다.
		   redirect는 브라우저에서 요청하는 것이기에 viewResolver를 참고할 수 없다.
		  
		 */
	}
	
	@RequestMapping("memberLogout.do")
	public ModelAndView logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return new ModelAndView("redirect:index.jsp");
	}

}















