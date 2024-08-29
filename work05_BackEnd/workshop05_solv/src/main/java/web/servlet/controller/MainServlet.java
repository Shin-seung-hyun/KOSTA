package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.vo.Product;
import web.servlet.vo.ProductDAOImpl;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String pName = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		
		Product product = new Product(pName, price, desc);
		
		try {
			ProductDAOImpl.getInstance().registerProduct(product);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		response.sendRedirect("List");
		//request.getRequestDispatcher("List").forward(request, response);
		
	}
}








