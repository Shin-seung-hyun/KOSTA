package web.servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

public class SearchController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchSelect = request.getParameter("searchSelect");
		String searchText = request.getParameter("searchText");
		System.out.println("aaaaaaaaaaaa ..."+searchText);
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().findBookList(searchSelect, searchText);
			
			request.setAttribute("list", list);
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("book/bookList.jsp");
	}

}
