package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemeberDAOImpl;

public class ShowAllController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path ="index.jsp";
		try {

			ArrayList<Member> list= MemeberDAOImpl.getInstance().showAllMember();
			
			request.setAttribute("list", list);
			path = "allView.jsp";
	
		} catch (SQLException e) {
		
		}
		
		return new ModelAndView(path);
	}

}
