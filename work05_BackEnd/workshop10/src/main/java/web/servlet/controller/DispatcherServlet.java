package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	/*
		이전 방식과 다른점
		hidden 태그로 요청을 제각각 받지 않았다.
		들어온 요청의 주소를 직접 인식시킨다.
	*/
	protected void doProcess(HttpServletRequest request, HttpServletResponse response){
		String requestURI = request.getRequestURI(); // ContextPath 를 받는다. web20_FactoryPattern/find.do
		String contextPath = request.getContextPath(); //web20_FactoryPattern
		
		System.out.println("requestURI : " + requestURI);
		System.out.println("contextPath : " + contextPath);
		
		//find.do만 추출해보자
		String command = requestURI.substring( contextPath.length() +1); //find.do
		System.out.println("command : " + command);
	
		//1. HandlerMapping의 createComponent 함수 호출, 이때 위의 command 넣기
		//	Controller 반환
		Controller controller = HandlerMapping.getFactory().createComponent(command);
		
		
		//2. Controller의 메소드 호출.. ModelAndView 반환
		//	네비게이션
		
		ModelAndView mv = null;
		String path = "index.jsp";
		
		try {
			mv = controller.handleRequest(request, response);
			
			//3. mv 안에 있는 값을 get
			path = mv.getPath();
			
			if(mv !=null) {
				if(mv.isRedirect()) response.sendRedirect(path); 
				else request.getRequestDispatcher(path).forward(request, response);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
