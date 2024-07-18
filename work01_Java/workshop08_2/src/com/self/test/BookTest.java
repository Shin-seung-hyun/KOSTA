package com.self.test;

import com.self.service.BookManager;
import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("21424", "Java Pro", "김하나", "kosta.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("35355", "분석설계", "소나무", "kosta.kr", 30000, "SW 모델링");
		Magazine m = new Magazine("35535", "Java World", "편집부", "java.com", 2018, 2, 7000, "첫걸음");

		System.out.println("**************************** 도서 목록 **********************************");
		BookManager bm = new BookManager();

		bm.addBook(b1);
		bm.addBook(b2);
		bm.addBook(m);

		Book[] searchedBooks = new Book[1000];
		searchedBooks = bm.getAllBook();

		// 도서가 한 권도 없을 때
		if (searchedBooks[0] == null)
			System.out.println("도서가 없습니다.");
		else {
			for (int i = 0; i < bm.getCount(); i++) {
				System.out.println(searchedBooks[i]);
			}
		}
		System.out.println();

		Book searchedBook = new Book();
		System.out.println("**************************** Isbn으로 검색 **********************************");
		searchedBook = bm.searchByIsbn("21424");
		if (searchedBook != null)
			System.out.println(searchedBook);
		else
			System.out.println("검색 결과 없음");
		System.out.println();

		System.out.println("**************************** Title로 검색 **********************************");
		searchedBook = bm.searchByTitle("분석설계");
		if (searchedBook != null)
			System.out.println(searchedBook);
		else
			System.out.println("검색 결과 없음");
		System.out.println();

		System.out.println("**************************** Book만 검색 **********************************");
		searchedBooks = bm.searchAllBooks();
		if (searchedBooks[0] == null)
			System.out.println("검색결과가 없습니다.");
		else {
			for (int i = 0; i < bm.getCount(); i++) {
				if (searchedBooks[i] == null)
					break;
				System.out.println(searchedBooks[i]);
			}
		}
		System.out.println();

		System.out.println("**************************** Magazine만 검색 **********************************");
		searchedBooks = bm.searchAllMagazines();
		if (searchedBooks[0] == null)
			System.out.println("검색결과가 없습니다.");
		else {
			for (int i = 0; i < bm.getCount(); i++) {
				if (searchedBooks[i] == null)
					break;
				System.out.println(searchedBooks[i]);
			}
		}
		System.out.println();

		System.out.println("**************************** 출판사로 검색 **********************************");
		searchedBooks = bm.searchByPublisher("Jaen.kr");
		if (searchedBooks[0] == null)
			System.out.println("검색결과가 없습니다.");
		else {
			for (int i = 0; i < bm.getCount(); i++) {
				if (searchedBooks[i] == null)
					break;
				System.out.println(searchedBooks[i]);
			}
		}
		System.out.println();

		System.out.println("**************************** 가격으로 검색 **********************************");
		searchedBooks = bm.searchByPrice(7001);
		if (searchedBooks[0] == null)
			System.out.println("검색결과가 없습니다.");
		else {
			for (int i = 0; i < bm.getCount(); i++) {
				if (searchedBooks[i] == null)
					break;
				System.out.println(searchedBooks[i]);
			}
		}
		System.out.println();

		System.out.println("총 가격: " + bm.getTotalPrice());
		System.out.println("평균 가격: " + bm.getAveragePrice());
	}

}
