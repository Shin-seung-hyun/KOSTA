package web.servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;



public class ShowAllController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		try {
			ArrayList<Member> list = MemberDAOImpl.getInstance().showAllMember();
			
			request.setAttribute("list", list);
			path = "allView.jsp";
			
			
		}catch(Exception e) {
			
		}	
		return new ModelAndView(path);
	}

}
