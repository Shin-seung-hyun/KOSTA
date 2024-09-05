package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String path = "";
		if(session.getAttribute("vo") !=null) {
			session.invalidate();
			path= "index.jsp";
		}
		return new ModelAndView(path);
	}

}
