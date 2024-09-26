package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;


public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
			try {
				Member vo=MemberDAOImpl.getInstance().findByIdMember(id);
				if(vo!=null) {
					request.setAttribute("vo", vo); //바인딩
					path = "find_ok.jsp";
				}
				
			}catch(Exception e) {
				
			}		
			return new ModelAndView(path);
	}

}
