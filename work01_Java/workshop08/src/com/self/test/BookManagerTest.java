package com.self.test;

import com.self.service.BookManager;
import com.self.util.Date;
import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;

public class BookManagerTest {

	public static void main(String[] args) {
		
		BookManager manager = BookManager.getInstance();
		
		System.out.println("=========== 1. insertBook ============");
		manager.insertBook(new Magazine(111, "잡지1","김작가","A출판사", 3000, new Date(2024,6)));
		manager.insertBook(new Magazine(103, "잡지2","최작가","B출판사", 10_000, new Date(2023,12)));
		manager.insertBook( new Magazine(501, "잡지3","박작가","A출판사", 25_000, new Date(2023, 8)));
		manager.insertBook( new Magazine(221, "잡지4","박작가","A출판사", 35_000, new Date(2023, 1)));
		
		manager.insertBook(new Novel(262, "소설1","이작가","B출판사", 25_000, "스릴러" ));
		manager.insertBook( new Novel(650, "소설1","이작가","C출판사", 50_000, "스릴러"));
		manager.insertBook( new Novel(701, "소설3","김작가","C출판사", 18_000, "추리"));
		manager.insertBook( new Novel(802, "소설4","김작가","A출판사", 22_000, "SF"));
		System.out.println(manager.printAllBooks());
		
		System.out.println("=========== 2-1. searchBook ============");
		System.out.println(manager.searchBooks(103));
		
		System.out.println("\n=========== 2-2. searchBook ============");
		for( Book b : manager.searchBooks("소설1")) {
			System.out.println(b);
		}
		System.out.println("\n=========== 2-3. searchBook ============");
		for( Book b :  manager.searchBooks(20_000, 30_000)) {
			System.out.println(b);
		}
		
		System.out.println("\n=========== 3. getSumPriceOfBooks ============");
		System.out.println("총 금액 : " + manager.getSumPriceOfBooks() + "원");
		
		System.out.println("\n=========== 4. getAvgPriceOfBooks ============");
		System.out.printf("평균 금액 : %.3f 원\n" , manager.getAvgPriceOfBooks());

		System.out.println("\n=========== 5. getNumberOfbooks ============");
		System.out.printf("전제 책은 총 %d 권\n", manager.getNumberOfbooks());
		
		//추가
		System.out.println("\n===========6.잡지 중 발행일이 이상 인 것 출력 ============");
		for(Book b : manager.searchMagazineByDate(new Date(2023, 6))) {
			System.out.println(b);
		}
	
		
	}

}
