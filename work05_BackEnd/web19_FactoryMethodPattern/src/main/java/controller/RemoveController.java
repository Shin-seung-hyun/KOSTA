package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveController implements Controller{
	
	private static RemoveController register = new RemoveController();
	private RemoveController() {}
	public static RemoveController getInstance() {
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
		System.out.println("RemoveController... remove 비즈니스로직 호출");
		
		return "remove_result.jsp";
	}

}
