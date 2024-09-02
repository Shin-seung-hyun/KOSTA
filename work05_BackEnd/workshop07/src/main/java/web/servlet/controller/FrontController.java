package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;
import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. command 값 받아오기
		String command = request.getParameter("command");
		String path = "";
		
		if(command.equals("login"))  path = login(request, response); //login.html
		else if(command.equals("bookRegister"))  path = bookRegister(request, response); //Book.html
		else if(command.equals("showAllBook"))  path = showAllBook(request, response); //bookView.jsp
		else if (command.equals("searchBook"))  path = searchBook(request, response); //bookView.jsp
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	
	private String searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";
		BookDAOImpl dao = BookDAOImpl.getInstance();
		
		try {
			String category = request.getParameter("category");
			String search = request.getParameter("search");
			
			ArrayList<Book> books = dao.searchBook( category, search);
			request.setAttribute("books", books);
			path= "./book/bookView.jsp";
			
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return path;
	
	}
	private String showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";
		BookDAOImpl dao = BookDAOImpl.getInstance();
		
		try {
			ArrayList<Book> books = dao.showAllBook();
			request.setAttribute("books", books);
			path= "./book/bookView.jsp";
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return path;
	
	}
	
	private String bookRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = "";
		String path= "";
		
		
		for(int i=0; i<bookNoList.length; i++) {
			if(i==bookNoList.length-1) {
				isbn += bookNoList[i];
			} else {
				isbn += bookNoList[i] + "-";
			}
		}
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String description = request.getParameter("bookSummary");
		
		Book book = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		
		BookDAOImpl dao = BookDAOImpl.getInstance();
		
		try {
			dao.registerBook(book);
			request.setAttribute("book", book);
			path= "./book/bookSuccess.jsp";
			
		} catch (SQLException e) {
			System.out.println("Register Failed.");
			response.sendRedirect("../error/error.html");  // error 페이지로 이동
		}
		
		return path;
	}
	
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 폼값 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		System.out.println("id" + id +"pass" + password);
		String path = "login.html";
		
		try {
			
			//2. 비즈니스 로직 호출
			User vo = UserDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			
			if(vo != null) {
				session.setAttribute("vo", vo);
				System.out.println("로그인 성공");
				
				path = "loginSuccess.jsp";
			}
			else {
				path = "loginError.jsp";
				System.out.println("로그인 실패");
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return path;
	}

}
