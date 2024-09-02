package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemeberDAOImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		
			결과 페이지
			login_result.jsp
			
			1. 폼값 받아오기
			2. DAO 호출해서 반환 값 받아오기
			3. session 받아와서 rvo 바인딩
			4. rvo 가 null 이 아니라면 login_result.jsp로 네비게이션 하기
		
		*/
		
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path = "index.html";
		
		try {
			Member rvo = MemeberDAOImpl.getInstance().login(id, pass);
			
			HttpSession session = request.getSession();
			
			/*
			 	Session에 바인딩 하는 경우
			 	1) 로그인 로직
			 	2) 정보 수정 로직
			  
			 */
			
			
			if(rvo !=null) {
				
				System.out.println("로그인 정보 찾음");
				session.setAttribute("vo", rvo);
				System.out.println("LoginServlet ... JSESSIONID :: " + session.getId());
				
				path = "login_result.jsp";
			}
						
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			path = "login_fail.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}
