package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Member;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		
		//DAO 리턴 받아서 비즈니스 로직 호출, VO 객체 받았다고 치고
		Member rvo = new Member(id, pass,"홍종각","종각");
		
		// 바인딩... 세션... 얻어와야 한다.
		// 클라이언트가 요청하는 순간 req, res 와 함께 서버상에 만들어진다.
		// 세션 안에는 클라이언드(브라우저)를 구분하기 위한 고유한 JSESSIONID 값이 있다. -> getId() 로 받아오기 가능
		
		//HttpSession session =request.getSession(true);
		HttpSession session =request.getSession();
		System.out.println("JSESSIONID :: " + session.getId());
		 
		//바인딩
		session.setAttribute("vo",rvo);
		 
		//네비게이션
		response.sendRedirect("BuyServlet");
		 
	}

}
