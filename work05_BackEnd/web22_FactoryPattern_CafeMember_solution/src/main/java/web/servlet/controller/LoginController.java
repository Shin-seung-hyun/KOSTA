package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "index.jsp";
		
		try {
			Member rvo=MemberDAOImpl.getInstance().login(id, password);
			
			//요청하면 세션은 서버에 자동적으로 만들어지고..개발자는 그걸 받아서 사용
			HttpSession session=request.getSession();
			if(rvo!=null) { //로그인 성공시에만 바인딩 진행..
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());
				path = "login_result.jsp";
			}			
		}catch(Exception e) {
			
		}		
		return new ModelAndView(path);
	}

}
