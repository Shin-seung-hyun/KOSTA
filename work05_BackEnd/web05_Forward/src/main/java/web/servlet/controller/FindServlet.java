package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;


@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FindServlet() {
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		  1.폼값 받아서
		  2. DAO 비즈니스 로직 호출 받고, form 값을 인자 값으로 주고
		  3. DB 반환값 받아서 
		  4. 바인딩 이때, Request의 setAttribute()
		  5. 네비게이션
		    
		*/
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String address = request.getParameter("address");
		
		//2. 3. 아직 DB 연결을 안했기에 DAO에서 특정 주소를 가지는 사람 한 사람 받았다고 하자
		Member mem = new Member("홍종각", 33, "종각");
		
		//4.
		request.setAttribute("mem", mem);
		
		//5. 서버 상에서 다이렉트로 다른(jsp)로 이동하는 방법 페이지 이동 : forwarding
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
		
	}

}
