package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Product;
import web.servlet.model.ProductDAOImpl;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 한국어 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1. 폼값 가져오기 trim 쓰기
		String name = request.getParameter("name");
		String price = request.getParameter("price").trim();
		String detail = request.getParameter("detail").trim();
		
		Product pvo = null;
		
		if(detail.equals("")) {
			pvo = new Product(name, Integer.parseInt(price));
		}
		else {
			pvo= new Product(name, Integer.parseInt(price), detail);
		}
		
		//path
		String path = "index.html";
		
		try {

			ProductDAOImpl.getInstance().registerProduct(pvo);
			
			ArrayList<Product> list = ProductDAOImpl.getInstance().findProducts();
			
			request.setAttribute("list", list);
			
			path = "list.jsp";	
	
		} catch (SQLException e) {
		
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	

}
