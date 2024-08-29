package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.vo.Product;
import web.servlet.vo.ProductDAOImpl;

@WebServlet("/List")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> list = null;
			
	//list 는 클래스와 라이프사이클을 같이한다.
	public ListServlet() {
		list = new ArrayList<Product>();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			list = ProductDAOImpl.getInstance().findProducts();
		} catch (SQLException e) {
			System.out.println(e);
		}

		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
}








