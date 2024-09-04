package web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.Count;
import com.algo.Kickboard;

@WebServlet("/front.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		if(command.equals("count"))wordCount(request, response);
		else if(command.equals("kickboard")) kickBoardCount(request, response);
		
	}
	
	private void wordCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//입력값 받아오기
		String words = request.getParameter("words");
		
		//자바 클래스 생성, 함수 호출
		String result = new Count().execute(words);
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}
	
	private void kickBoardCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		
		// 파일정보 File 객체는 = 경로 + 파일 이름 이다.
		String fname = request.getParameter("fname");  // 출력 : input.txt 파일명이 출력된다.
		
		String path =request.getServletContext().getRealPath("res"); // contextPath까지
		System.out.println("path -----> " + path); // was의 경로가 보임 
												   //C:\KOSTA_SSH\apache-tomcat-9.0.93\webapps\workshop09\res
		
		File f = new File(path, fname);
		
		// 알고리즘이 static 메소드로 선언됐기에
		int result = Kickboard.execute(f);

		// wordCount와 같은 이름으로 바인딩
//		request.setAttribute("result", result);
//		request.getRequestDispatcher("Result.jsp").forward(request, response);
	
		
		/* forward 네비게이션을 하지 않고 ajax의 결과를 전송할 때*/
		PrintWriter out = response.getWriter();
		out.print(result);

	}

}










