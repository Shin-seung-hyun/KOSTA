package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

@WebServlet("/book/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			
			String[] isbnArr = request.getParameterValues("bookNo");
			String bookTitle = request.getParameter("bookTitle");
			String bookCategory = request.getParameter("bookCategory");
			String bookCountryArr = request.getParameter("bookCountry");
			String bookDate = request.getParameter("bookDate");
			String bookPublisher = request.getParameter("bookPublisher");
			String bookAuthor = request.getParameter("bookAuthor");
			int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
			String currency = request.getParameter("bookPrice2");
			String bookSummary = request.getParameter("bookSummary");
			
			Book book = new Book(isbnArr[0] + "-" + isbnArr[1] + "-" + isbnArr[2],
								bookTitle,
								bookCategory,
								bookCountryArr,
								bookDate,
								bookPublisher,
								bookAuthor,
								bookPrice,
								currency,
								bookSummary);
			
			BookDAOImpl.getInstance().registerBook(book);
			
			HttpSession session = request.getSession();
			session.setAttribute("vo", book);
			
			request.getRequestDispatcher("bookSuccess.jsp").forward(request, response);
			
		}
		catch (SQLException e) {
			
			System.out.println(e);
			
			HttpSession session = request.getSession();
			session.setAttribute("error", "[SQL]"+e.getMessage());
			
			response.sendRedirect("../error/error.jsp");
		}
		
		catch (Exception e) {
			
			System.out.println(e);
			
			HttpSession session = request.getSession();
			session.setAttribute("error", e.getMessage());
			
			response.sendRedirect("../error/error.jsp");
		}
		
		
	}

}
