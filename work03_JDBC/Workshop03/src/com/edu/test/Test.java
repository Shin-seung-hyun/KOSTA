package com.edu.test;

import java.util.List;

import com.edu.Book;
import com.edu.dao.BookDAO;
import com.edu.exception.DMLException;
import com.edu.exception.DuplicateISBNException;
import com.edu.exception.RecordNotFoundException;

public class Test {
	
	private static void printAllBooks(List<Book> list) {
		for (Book book : list) {
			System.out.println(book);
		}
	}

	public static void main(String[] args){
		BookDAO dao = BookDAO.getInstance();
		

		// 하나라도 에러 시 모두 종료
//		try {
//			// 1.
//			System.out.println("\n1.");
//			dao.insertBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 23000, "기본"));
//			dao.insertBook(new Book("a1102", "JAVA 중급", "자앤 기술연구소", "자앤 출판사", 25000, "중급"));
//			dao.insertBook(new Book("a1103", "JAVA 실전", "자앤 기술연구소", "한빛 출판사", 30000, "실전"));
//			dao.insertBook(new Book("b1103", "C 실전", "자앤 기술연구소", "미래 출판사", 30000, "실전"));
//			
//			// 2.
//			System.out.println("\n2.");
//			printAllBooks(dao.listBooks());
//			
//			// 3.
//			System.out.println("\n3.");
//			System.out.println(dao.findBook("a1101"));
//			
//			// 4.
//			System.out.println("\n4.");
//			dao.insertBook(new Book("a1104", "JAVA 심화", "자앤 기술연구소", "자앤 출판사", 28000, "심화"));
//			
//			// 5.
//			System.out.println("\n5.");
//			dao.updateBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 20000, "기본"));
//			printAllBooks(dao.listBooks());
//			
//			// 6.
//			System.out.println("\n6.");
//			dao.deleteBook("a1103");
//			printAllBooks(dao.listBooks());
//			
//			// 7.
//			System.out.println("\n7.");
//			System.out.println(dao.count());
//	
//			
//		} catch (DuplicateISBNException e) {
//			System.out.println(e.getMessage());
//		}catch (DMLException e) {
//			System.out.println(e.getMessage());
//		}catch (RecordNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
	
		
		/* workshop03*/
		
		try {
			
//			dao.insertBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 23000, "기본"));
//			dao.insertBook(new Book("a1102", "JAVA 중급", "자앤 기술연구소", "자앤 출판사", 25000, "중급"));
//			dao.insertBook(new Book("a1103", "JAVA 실전", "자앤 기술연구소", "한빛 출판사", 30000, "실전"));
//			dao.insertBook(new Book("b1103", "C 실전", "자앤 기술연구소", "미래 출판사", 30000, "실전"));
			
			System.out.println("==============================");
			//책 타이틀로 검색
			dao.serachByTitle("JAVA").stream().forEach(i->System.out.println(i));
			
			//출판사 별로 검색
			dao.serachByPublisher("자앤").stream().forEach(i->System.out.println(i));
			
			//작가 별 검색
			dao.serachByAuthor("자앤").stream().forEach(i->System.out.println(i));
			
			//가격대 별 검색
			dao.serach(25000, 20000).stream().forEach(i->System.out.println(i));
			
			//특정 출판사가 도서가격 20% 할인 이벤트
			dao.discontByPublisher(0.2, "한빛");
			printAllBooks(dao.listBooks());
			
			
		} catch (DMLException e) {
			e.getMessage();
		}
		
		
		
	}
}
