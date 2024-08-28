package web.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Product;


@WebServlet("/List")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private ArrayList<Product> list =null;
 
    public ListServlet() { 
    	list= new ArrayList<>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.DAO로 비즈니스 로직 호출
		Product p1 = new Product(1,"AAA",15000, "A+++");
		Product p2 = new Product(2,"BBB",13000, "B+++");
		Product p3 = new Product(3,"CCC",12000, "C+++");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		
	}

}
