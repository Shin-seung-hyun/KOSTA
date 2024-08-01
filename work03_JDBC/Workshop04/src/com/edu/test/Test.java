package com.edu.test;

import java.util.List;

import com.edu.Book;
import com.edu.dao.BookDAO;
import com.edu.exception.DMLException;
import com.edu.exception.DuplicateISBNException;
import com.edu.exception.RecordNotFoundException;

public class Test {

	public static void main(String[] args){
		BookDAO dao = BookDAO.getInstance();
	
		/* workshop04*/
		try {
			
			//3.
			System.out.println("3.Book과 Author 테이블을 JOIN하여 도서명, 가격, 저자명을 검색하는 기능");
			dao.search();
			
			//4.
			System.out.println("\n4. 이름이 ‘ 김XX ’인 저자의 도서명, isbn, 출판사를 출력하는 기능 ");
			dao.search("김승현");
			
			//5.
			System.out.println("\n5. 저자명 별로 출간된 도서들을 도서명, 출판사, 가격, 저자명을 출력하는 기능");
			dao.serachByAuthor("김작가");
			
			//6. 
			System.out.println("\n6.Book 테이블에 concat( ‘IoT세상은 미래닷컴에서 출판했다’)");
			dao.bookPrint();
			
			
		} catch (DMLException e) {
			e.getMessage();
		}
		
		
	}
}
