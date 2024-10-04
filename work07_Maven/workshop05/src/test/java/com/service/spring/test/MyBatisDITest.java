package com.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

public class MyBatisDITest {
	
	ApplicationContext factory = new ClassPathXmlApplicationContext("/beans/businessBean.xml");
	
	//MyBatis DI 연동 부분의 단위 테스트 -> bean 설정문서를 읽어야 한다.
	@Test
	public void addTest() throws Exception {
		
		BookService service = (BookService) factory.getBean("bookService");
		
		List<Book> list = service.searchByTitle("도서");
		for(Book b : list) System.out.println(b);
	}
	
	@Test
	public void findTest() throws Exception{
		
		
		
	}
	

}
