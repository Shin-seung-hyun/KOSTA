package web.servlet.controller;

import java.io.DataOutput;
import java.io.IOException;
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
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
//		if(id.equals("kosta") && password.equals("1234") ) {
//			
//			// DB에서 id와 password에 해당하는 User 객체 가져오기
//			User user = new User(id, password,"신승현","종각");
//			request.setAttribute("user", user);
//			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
//			
//		}
//		else {
//			request.getRequestDispatcher("loginError.jsp").forward(request, response);
//		}
		
		
	}

}
