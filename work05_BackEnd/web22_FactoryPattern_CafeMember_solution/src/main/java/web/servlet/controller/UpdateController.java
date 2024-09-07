package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;


public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String path = "index.jsp";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Member pvo = new Member(id, password, name, address);	
		
		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) { //로그인된 상태일때만
				session.setAttribute("vo", pvo);
				path = "update_result.jsp";
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return new ModelAndView(path);
	}

}
