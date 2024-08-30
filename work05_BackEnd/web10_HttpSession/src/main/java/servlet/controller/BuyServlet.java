package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//HttpSession session =request.getSession(false);
		HttpSession session =request.getSession();
		
		if(session.getAttribute("vo") != null) { // 기존에 세션을 사용한다.(= 로그인이 됐다면)
			System.out.println("BuyServlet JSESSIONID ::" + session.getId());
			
			session.setAttribute("pname", "WideTV");
			
			request.getRequestDispatcher("buy_result.jsp").forward(request, response);
		}
		else { // 로그인이 안됐다면(= 로그인 페이지로 네비게이션 하기)
			
			response.sendRedirect("login.html");
		}
		
	}


}
