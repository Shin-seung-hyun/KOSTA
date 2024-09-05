package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemeberDAOImpl;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path = "index.html";
		
		try {
			Member rvo = MemeberDAOImpl.getInstance().login(id, pass);
			
			HttpSession session = request.getSession();

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
		
		return new ModelAndView(path);
	}

}
