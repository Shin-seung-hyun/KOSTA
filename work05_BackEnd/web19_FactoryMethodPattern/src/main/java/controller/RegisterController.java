package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController implements Controller{
	
	private static RegisterController register = new RegisterController();
	private RegisterController() {}
	public static RegisterController getInstance() {
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
		
		System.out.println("RegisterController... register 비즈니스로직 호출");
		
		return "register_result.jsp";
	}

}
