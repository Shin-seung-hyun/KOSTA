package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller{
	
	private static LoginController register = new LoginController();
	private LoginController() {}
	public static LoginController getInstance() {
		return register;
	}
	

	@Override
	public String handel(HttpServletRequest request, HttpServletResponse response) {
		
		
		/*
		  1. 폼값 받아서
		  2. DAO 리턴
		  3. 데이터 바인딩
		  4. 네비게이션
		   
		 */
		
		System.out.println("LoginController... Login 비즈니스로직 호출");
		
		return "login_result.jsp";
	}

}
