package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Product;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
    	
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 한국어 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1. 폼 값 받아오기
		String name =(String)request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String detail = (String)(request.getParameter("detail"));
		
		//2. DAO 비즈니스 로직에서 VO반환 받음
		Product product = new Product(1, name, price, detail);
		
		if(product != null) {
			//3. 바인딩
			request.setAttribute("product", product );
			
			//4. 네비게이션
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
		else {
			System.out.println(" DB에 해당 상품이 없습니다.");
		}
		
		
	}

}
