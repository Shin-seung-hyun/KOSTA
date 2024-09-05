package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "login.jsp";
		
		try {
			
			//세션을 죽이는 로직 + path를 logout.jsp로 변경
			HttpSession session= request.getSession();
			
			if( session.getAttribute("vo") != null) { // 로그인이 돼있다면 
				session.invalidate();
				path = "logout.jsp";
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return new ModelAndView(path);
	}

}
