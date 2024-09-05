package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

public class BookListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Book> list;
		try {
			list = BookDAOImpl.getInstance().showAllBook();			
			request.setAttribute("list", list);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView("book/bookList.jsp");
	}

}
