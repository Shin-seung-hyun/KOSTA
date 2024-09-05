package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

public class DetailViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String isbn = request.getParameter("isbn");
		try {
			Book book=BookDAOImpl.getInstance().findBook(isbn);
			System.out.println("Book..detailView"+book);
			
			request.setAttribute("book", book);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("./book/detail.jsp");
	}

}
