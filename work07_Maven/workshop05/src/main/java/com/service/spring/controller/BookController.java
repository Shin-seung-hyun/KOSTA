package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("bookList.do")
	public ModelAndView getBooks() throws Exception{
		List<Book> list = bookService.getBooks();
		
		return new ModelAndView("book/bookList", "list", list);
	}
	
	@RequestMapping("bookRegister.do")
	public ModelAndView register(
			int isbn1, int isbn2, int isbn3,
			Book book , HttpServletRequest request) throws Exception{
		System.out.println("register BookVO before:: "+ book);
		
		String msg = "책 등록에 실패했습니다.";
		String path = "Error.jsp";
		
		try {
			
			System.out.println(book.getIsbn());
			System.out.println(isbn1 + " " + isbn2 + " " + isbn3);
			book.setIsbn(isbn1 +"-" + isbn2 + "-" + isbn3);
			bookService.insertBook(book);
			
		
			msg ="책 등록에 성공했습니다.";
			path = "index.jsp";
			
			return new ModelAndView("redirect:" + path);
					
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		request.setAttribute("msg", msg);
		return new ModelAndView("redirect:" + path);
	}
	
	@RequestMapping("bookSearch.do")
    public ModelAndView search(String searchField , String searchText, HttpServletRequest request) throws Exception{ 
		
		List<Book> list = null;
		String path = "Error.jsp";
		String msg = "책 검색에 실패했습니다.";
		
		try {
			
			System.out.println("searchField : " + searchField + " searchText: " + searchText);
			 
			
			if(searchField.equals("LIST")) 
				list = bookService.getBooks();
			
			else if( searchField.equals("TITLE")) {
				list = bookService.searchByTitle(searchText);
				System.out.println(list);
			}
			else if( searchField.equals("PUBLISHER"))
				list = bookService.searchByPublisher(searchText);
			
			else {
				int price =Integer.parseInt(searchText);
				System.out.println("price " + price);

				list = bookService.searchByPrice(price);
			}
			return new ModelAndView("book/bookList", "list", list);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("msg", msg);
		return new ModelAndView("redirect:" + path);
	}
	
	
	@RequestMapping("bookView.do")
    public ModelAndView bookview(String isbn, HttpServletRequest request)throws Exception{
		
		String path = "Error.jsp";
		String msg = "책 상세보기에 실패했습니다.";
		
		try {
			
			Book book = bookService.searchByIsbn(isbn);
			return new ModelAndView( "book/bookView","book", book);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("msg", msg);
		return new ModelAndView("redirect:" + path);
	}	

}





