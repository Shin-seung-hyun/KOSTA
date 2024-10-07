package com.service.spring.test;

import java.awt.print.Book;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;


public class DIUnitTest {
	
	ApplicationContext factory = new ClassPathXmlApplicationContext("/beans/application.xml");
	BoardService service = (BoardService)factory.getBean("boardService");
	
	@Test
	public void write()  throws Exception {
		System.out.println("===== 1. write =====");
		Board board = new Board("MyBatis 공부법4", "열심히 공부한다", new Member("1111", "12345", "홍길동", "종각"));
		System.out.println(service.write(board));
	}
		
	@Test
	public void getBoardList()  throws Exception {
		System.out.println("===== 2. getBoardList =====");
		List<Board> list = service.getBoardList();
		for(Board b : list) System.out.println(b);
	}
	
	@Test
	public void showContent()  throws Exception {
		System.out.println("===== 3. showContent =====");
		Board board = service.showContent(2);
		System.out.println(board);
	}

}
