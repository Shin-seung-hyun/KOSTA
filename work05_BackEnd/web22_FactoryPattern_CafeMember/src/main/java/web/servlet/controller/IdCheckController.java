package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.MemeberDAOImpl;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean find  = false;
		String path ="";
		try {
			
			//PrintWriter out = response.getWriter();
			
			//폼값 받아서 
			//비즈니스 로직 호출 -> T/F 리턴 idExist()
			String id = request.getParameter("userId");
			
			find = MemeberDAOImpl.getInstance().idExist(id);
			request.setAttribute("find", find);
			
			System.out.println(id + ", " + find);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		path= "idCheck_result.jsp";
		
		return new ModelAndView(path);
	}

}
