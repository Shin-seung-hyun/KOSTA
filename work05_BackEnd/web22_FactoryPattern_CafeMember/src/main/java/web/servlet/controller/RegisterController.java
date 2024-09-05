package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemeberDAOImpl;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Member pvo = null;
		String path = "index.jsp";
		
		if(name.equals(" ") || address.equals(" ")) {
			pvo = new Member(id, password);
		}
		else {
			pvo= new Member(id, password, name, address);
		}

		try {

			MemeberDAOImpl.getInstance().registerMember(pvo);
			
			path = "register_result.jsp";	
	
		} catch (SQLException e) {
		
		}
		
		return new ModelAndView(path);
	}

}
