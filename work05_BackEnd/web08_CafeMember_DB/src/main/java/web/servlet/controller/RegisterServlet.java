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


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 한국어 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1. 폼값 가져오기 trim 쓰기
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Member pvo = null;
		
		if(name.equals(" ") || address.equals(" ")) {
			pvo = new Member(id, password);
		}
		else {
			pvo= new Member(id, password, name, address);
		}
		//path
		String path = "index.html";
		
		try {

			MemeberDAOImpl.getInstance().registerMember(pvo);
			
			path = "register_result.jsp";	
	
		} catch (SQLException e) {
		
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
}
