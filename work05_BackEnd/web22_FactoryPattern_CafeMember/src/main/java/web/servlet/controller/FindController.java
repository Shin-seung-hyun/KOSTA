package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemeberDAOImpl;

/*
 	Component란?
	 	인터페이스 기반으로 작성된 재사용성 강한 자바 클래스
	 	폼값 받아서 
	 	DAO 리턴 받고 비즈니스 로직 호출 .. 데이터 반환
	 	데이터 바인딩
	 	네비게이션
 
 */
public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		try {
			
			Member rvo= MemeberDAOImpl.getInstance().findByIdMember(id);
			
			if(rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}	
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView(path);
	}

}
