package web.servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/front.do")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Ajax가 보낸 form 값 받아서  
		//DAO 비지니스 로직 호출 시 인자값으로 넣어줌
		// VO반환값 받아서 바인딩 (받았다고 치고)
		// 네비게이션 result.jsp
		
		String id = request.getParameter("id");
		
		try {
			Thread.sleep(2000);
			
		}catch (InterruptedException e) {
			
		}
		
		
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}

}
