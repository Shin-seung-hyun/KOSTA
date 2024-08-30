package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;


@WebServlet("/Login")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0. 한국어 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1. 폼값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path ="index.html";
		
		try {
			
			System.out.println(id);
			System.out.println(password);
			
			User vo = UserDAOImpl.getInstance().login(id, password);
			
			HttpSession session = request.getSession();
			
			if(vo != null) {
				System.out.println("로그인 정보 찾음");
				session.setAttribute("user", vo);
				
				path = "loginSuccess.jsp";
				
				request.getRequestDispatcher(path).forward(request, response);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			path ="loginError.jsp";
			
			response.sendRedirect(path);
		}
		
		
	
	}

}
