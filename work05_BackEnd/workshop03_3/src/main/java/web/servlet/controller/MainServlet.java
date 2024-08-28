package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.User;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0. 한국어 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=  response.getWriter(); 
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		if(id.equals("kosta") && password.equals("1234") ) {
			
			User user = new User(id, password,"신승현","종각");
			request.setAttribute("user", user);
			
			//페이지 이동
			//request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			
			// 아래 코드는 에러가 발생한다.
			out.println("<a href ='loginSuccess.jsp'>Sucess Page 이동</a>");
			
		}
		else {
			//request.getRequestDispatcher("loginError.jsp").forward(request, response);
			out.println("<a href ='loginError.jsp'>Error Page 이동</a>");
		}
		
		
	}

}
