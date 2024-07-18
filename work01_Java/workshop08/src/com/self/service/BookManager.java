package com.self.service;

import com.self.util.Date;
import com.self.vo.Book;
import com.self.vo.Magazine;

/**
 * {@code
 * 
 * 		도서관 운영 기능을 제공하는 클래스
 * 	 
 * }
 * 
 *  @author SHIN SEUNG HYUN
 *  @version BookManager Project version 1.0.1
 *  @since JDK 17
 * 
 */
public class BookManager {
	
	/**
	 * 책 배열 사이즈
	 */
	private static final int NUMBEROFBOOK = 10;
	
	/**
	 * 현재 책 배열의 index
	 */
	private int idx;
	
	/**
	 *  책을 저장할 배열
	 */
	//Book[] books = new Book[NUMBEROFBOOK];
	Book[] books;
	
	/**
	 * 싱글톤 패턴을 위한 객체 생성
	 */
	private static BookManager manager = new BookManager();
	
	/**
	 * BookManager의 생성자
	 */
	private BookManager() {
		books = new Book[NUMBEROFBOOK];
	}
	
	/**
	 * @return BookManager
	 */
	public static BookManager getInstance() {
		return manager;
	}
	
	/**
	 * 책의 수를 알려주는 기능
	 * @return 책 배열의 길이 반환
	 */
	public int getNumberOfbooks() {
		return books.length;
	}
	
	/**
	 * 책을 입력하는 기능
	 * @param b 책 객체 입력
	 */
	public void insertBook(Book b) {
		
		if( idx < NUMBEROFBOOK )
			books[idx++] = b;
	}
	
	
	/**
	 * 책 바코드를 기준으로 책 검색하는 기능 
	 * @param isbn 바코드
	 * @return Book 바코드에 해당하는 책 객체 반환
	 */
	public Book searchBooks(int isbn) {
		
		for(Book b : books) {
			if(b.getIsbn() == isbn) return b;
		}
		
		return null;
	}
	
	/**
	 * 책의 제목이 title인 것 검색하는 기능
	 * @param title : 책이름
	 * @return Book[] : 책 이름에 해당하는 책 배열 반환
	 */
	public Book[] searchBooks(String title) {
		
		int size =0;
		for(Book b : books) {
			if(b ==null)break;
			if(b.getTitle().contains(title)) size++;
		}
		
		Book[] tmp = new Book[size];
		for(Book b : books) {
			if (b == null) continue;
			if( b.getTitle().contains(title)) tmp[--size] = b;
		}
		
		return tmp;
	}
	
	/**
	 * 책의 가격이 minPirce 이상 maxPrice 이하인 책을 검색하는 기능 
	 * @param minPrice 책 가격
	 * @param maxPrice 책 가격
	 * @return Book[] 일정금액 이상 이하인 책 배열을 반환
	 */
	public Book[] searchBooks(int minPrice, int maxPrice) {
		
		int size =0;
		for(Book b : books) {
			if( b == null) continue;
			if( b.getPrice() >= minPrice && b.getPrice() <= maxPrice) size++;
		}
		
		Book[] tmp = new Book[size];
		for(Book b : books) {
			if( b == null) continue;
			if( b.getPrice() >= minPrice && b.getPrice() <= maxPrice) tmp[--size] = b;
		}
		
		return tmp;
		
	}
	
	/**
	 * 잡지책 중 발행일이 일정 기간 이상인 책을 검색하는 기능 
	 * @param date : 기간 입력
	 * @return Book[] : 일정 기간 이상인 매거진 반환
	 * 
	 */
	public Book[] searchMagazineByDate(Date date) {
		int size =0;
		for(Book b : books) {
			if( b == null) continue;
			if( b instanceof Magazine) {

				 int year = ((Magazine) b).getPubDate().getYear();
				 int month = ((Magazine) b).getPubDate().getMonth();
				 
				if( year >= date.getYear() && month >= date.getMonth()) size++;
			}
		}
		
		Book[] tmp = new Book[size];
		for(Book b : books) {
			if( b == null) continue;
			if( b instanceof Magazine) {

				 int year = ((Magazine) b).getPubDate().getYear();
				 int month = ((Magazine) b).getPubDate().getMonth();
				 
				if( year >= date.getYear() && month >= date.getMonth()) tmp[--size] = b;
			}
		}
		
		return tmp;
	}
	
	
	/**
	 * 
	 * 전체 책의 가격을 반환하는 기능
	 * @return double 책의 가격 총합을 반환
	 */
	public double getSumPriceOfBooks() {
		
		double sum = 0;
		for(Book b : books) {
			if(b == null) break;
			sum += b.getPrice();
		}
		
		
		return sum;
	}
	
	/**
	 * 
	 * 전체 책의 가격 평균을 반환하는 기능 
	 * @return double 책의 평균을 반환
	 */
	public double getAvgPriceOfBooks() {
		
		return getSumPriceOfBooks() / idx ;
	}
	
	/**
	 * 
	 * 전체 책을 프린트하는 기능
	 * @return String 전체 책을 출력
	 */
	public String printAllBooks() {
		
		String str = "";
		for(Book b : books) {
			if(b == null) break;
			str += b + "\n";
		}
		
		return str;
	}

}
