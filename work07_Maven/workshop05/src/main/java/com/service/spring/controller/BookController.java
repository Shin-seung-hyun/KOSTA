package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("bookList.do")
	public ModelAndView getBooks() throws Exception{
		List<Book> list = bookService.getBooks();
		
		return new ModelAndView("book/bookList", "list", list);
	}
	
	@PostMapping("bookRegister.do")
	public ModelAndView register(	String isbn1, 
									String isbn2, 
									String isbn3,
									Book book,
									HttpServletRequest request) throws Exception{
		
		System.out.println("register BookVO before:: "+ book); //book 정보에 isbn = null 인 것을 확인
		book.setIsbn(isbn1 +"-" + isbn2 + "-" + isbn3);
		System.out.println("register BookVO after:: "+ book);
		
		String msg = "도서 등록에 실패했습니다.";
		String path = "redirect:Error.jsp";
		
		try {
			
			bookService.insertBook(book); // try문 안에 있음으로 DB에 book 정보가 정상적으로 입력됨
			
			msg ="도서 등록에 성공했습니다.";
			path = "redirect:result.jsp"; // 원래는 forward를 해야 함.
					
		}catch(DuplicateKeyException e) {//DB에 book 정보가 정상적으로 입력되지 않았다면
			
			System.out.println( "register 실패 !!!!..... " + e.getMessage());
			msg ="isbn이 중복 등록 했습니다.";
			
		}catch(Exception e ) {
			
			System.out.println( "register 실패 !!!!..... " + e.getMessage());
		}
	
		//redirect 시에는 세션에 저장해야 함
		request.getSession().setAttribute("msg", msg);
		return new ModelAndView(path);
	}
	
	
	@GetMapping("bookSearch.do")
    public ModelAndView search(String searchField , String searchText, HttpServletRequest request) throws Exception{ 
		
		List<Book> list = null;
		String path = "redirect:Error.jsp";
		String msg = "도서 검색 중 오류가 발생했습니다.";
		
		try {
			
			System.out.println("searchField : " + searchField + " searchText: " + searchText);
			
			//switch 문 내 String값이 들어갈 때는 반드시 JDK 버전이 8이상이어야 한다. 
			//pom.xml 내 <java-version>1.8</java-version>
			switch (searchField) {
			case "TITLE":
				list = bookService.searchByTitle(searchText);
				break;
			case "PUBLISHER":
				list = bookService.searchByPublisher(searchText);
				break;
			case "PRICE":
				int price =Integer.parseInt(searchText);
				list = bookService.searchByPrice(price);
				break;				
			default:
				list = bookService.getBooks();
				break;
			}
		
			path = "book/bookList";// InternalResourcesViewResolver 동작
			msg = "도서 검색을 정상적으로 수행했습니다.";
			
			request.setAttribute("field", searchField);
			request.setAttribute("text", searchText);
			
		}catch(Exception e) {
			System.out.println( "Search 수행 중 에러 발생!!!!....."+ e.getMessage());
		}
		
		request.getSession().setAttribute("msg", msg);
		return new ModelAndView(path, "list", list); //forwarding request에 바인딩된다.
	}
	
	
	@GetMapping("bookView.do")
    public ModelAndView bookview(String isbn)throws Exception{
		
		Book book = null;
		String path = "redirect:Error.jsp";
		String msg = "isbn으로 검색 중 오류가 발생했습니다. (상세보기  실패)";
		
		try {
			
			book = bookService.searchByIsbn(isbn);
			path = "book/bookView";
			msg = "상세보기 검색 성공";
			
		}catch(Exception e) {
			System.out.println( "bookview 수행 중 에러 발생"+ e.getMessage());
		}
		
		return new ModelAndView(path, "book", book);
	}	

}





