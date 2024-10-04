package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.Book;

public class MyBatisUnitTest {

	public static void main(String [] args) throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
//		System.out.println("1. addUser");
//		User pvo = new User();
//		pvo.setUserId("kosta2");
//		pvo.setName("kim");
//		pvo.setPassword("1234");
//		pvo.setEmail("123@naver.com");
//		System.out.println(session.insert("ns.sql.UserMapper.addUser", pvo));
//		
//		System.out.println("=======================================================");
//		System.out.println("2. getUser");
//		User pvo2 = new User();
//		pvo2.setUserId("admin");
//		System.out.println(session.selectOne("ns.sql.UserMapper.getUser", pvo2) );
//		
//		System.out.println("=======================================================");
//		System.out.println("3. getUser");
//		User pvo3 = new User();
//		pvo3.setUserId("java");
//		pvo3.setPassword("java");
//		System.out.println(session.selectOne("ns.sql.UserMapper.getUser", pvo3) );
		
		System.out.println("1. insertBook");
		Book pvo = new Book("6666-777-888",
							"Maven",
							"프로그래밍",
							"국내도서",
							"2024-10-04",
							"한빛미디어",
							"최저자",
							6000, 
							"재미있어요");
		System.out.println(session.insert("ns.sql.BookMapper.insertBook", pvo));
		session.commit();
		System.out.println();
		
		System.out.println("2. getBooks");
		List<Book> list= session.selectList("ns.sql.BookMapper.getBooks");
		for(Book b : list) System.out.println(b);
		session.commit();
		System.out.println();
		
		System.out.println("3. searchByTitle");
		List<Book> list2= session.selectList("ns.sql.BookMapper.searchByTitle", "도서");
		for(Book b : list2) System.out.println(b);
		session.commit();
		System.out.println();
		
		System.out.println("4. searchByPublisher");
		List<Book> list3= session.selectList("ns.sql.BookMapper.searchByPublisher", "코스타");
		for(Book b : list3) System.out.println(b);
		session.commit();
		System.out.println();
		
		System.out.println("5. searchByPrice");
		List<Book> list4= session.selectList("ns.sql.BookMapper.searchByPrice", 6000);
		for(Book b : list4) System.out.println(b);
		session.commit();
		System.out.println();
		
		System.out.println("6. searchByIsbn");
		System.out.println(session.selectOne("ns.sql.BookMapper.searchByIsbn", "1234-123-123"));
		session.commit();
		System.out.println();
		
		System.out.println("7. delete");
		System.out.println(session.delete("ns.sql.BookMapper.delete", "1234-123-123") );
		session.commit();
		System.out.println();
		
		System.out.println("8. getIsbn");
		System.out.println(session.selectOne("ns.sql.BookMapper.getIsbn", "1234-111-222") );
		session.commit();
		System.out.println();
		
		System.out.println("9. update");
		pvo.setTitle("AAA");
		System.out.println(session.update("ns.sql.BookMapper.update", pvo) );
		session.commit();
		System.out.println();
		
		
	}
}
