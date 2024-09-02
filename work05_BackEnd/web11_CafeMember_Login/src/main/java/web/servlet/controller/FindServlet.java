package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemeberDAOImpl;


@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FindServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get 방식 요청을 처리한다.
		// 가진 모든 것을 전달
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//post 방식 요청을 처리한다.
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//로직은 여기서 작성
		/*
		 회원 검색 로직
		 0. 양방향 한글 처리                                     
		 1. 폼 값을 받아와서
		 2. DAO에 findByIdMember(id) 넣고 검색
		 3. 반환 받은 VO가 null이 아니라면,
		 4. 바인딩
		 5. 네비게이션		  
		  
		 */
		
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		try {
			
			Member rvo= MemeberDAOImpl.getInstance().findByIdMember(id);
			
			if(rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}	
			
		} catch (SQLException e) {
		
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
