package web.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/front.do")
public class JQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		if(command.equals("subject")) {
			subject(request,response);
		}
		else if(command.equals("company")) {
			company(request, response);
		}
		
	}

	private void subject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DAO 리턴 받고 비즈니스 로직 호출, 데이터 바로 응답하기
		String result = "Big Data | Python | Java OOP | JDBC & Modeling | SpringMVC ";
		
		PrintWriter out = response.getWriter();
		
		out.print(result); // 응답하는 순간 success function의 인자값으로 전달됨
		
	}
	
	private void company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String result = "<ul><li>Tomato System</li><br>"
						+ "<li>Apple</li><br>"
						+ "<li>NCSoft Coporation</li><br>"
						+ "<li>Naver</li><br>"
						+ "<li>KB</li></ul>";
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
	}
}
