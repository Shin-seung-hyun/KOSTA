package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
         
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 세부 로직 구현
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("Seervlet..."+id);
		try {
			User rvo = UserDAOImpl.getInstance().login(id, password);

			HttpSession session = request.getSession();

			if (rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID: " + session.getId());
				
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			} else {				
				response.sendRedirect("./error/error.html");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}




















