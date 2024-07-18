package com.self.service;

import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookManager {
	private Book[] items = new Book[1000];
	private int index = 0;
	private int totalPrice = 0;
	
	public void addBook(Book b) {
		items[index++] = b;
		totalPrice += b.getPrice();
	}
	
	public int getCount() {
		return index;
	}
	
	public Book[] getAllBook() {
		return items;
	}
	
	public Book searchByIsbn(String isbn) {
		for(Book item : items) {
			if(item == null)break;
			if(item.getIsbn().equals(isbn)) {
				return item;
			}
		}
		return null;
	}
	
	public Book searchByTitle(String title) {
		for(Book item : items) {
			if(item == null)break;
			if(item.getTitle().equals(title)) {
				return item;
			}
		}
		return null;
	}
	
	public Book[] searchAllBooks() {
		Book[] searchedBooks = new Book[1000];
		int idx = 0;
		
		for(Book item : items) {
			if(item == null)break;
			if(item instanceof Magazine) {
				continue;
			}
			searchedBooks[idx++] = item;
		}
		
		return searchedBooks;
	}
	
	public Book[] searchAllMagazines() {
		Book[] searchedBooks = new Book[1000];
		int idx = 0;
		for(Book item : items) {
			if(item == null)break;
			if(item instanceof Magazine) {
				searchedBooks[idx++] = item;
			}
		}
		
		return searchedBooks;
	}
	
	public Book[] searchByPublisher(String publisher) {
		Book[] searchedBooks = new Book[1000];
		int idx = 0;
		for(Book item : items) {
			if(item == null)break;
			if(item.getPublisher().equals(publisher)) {
				searchedBooks[idx++] = item;
			}
		}
		return searchedBooks;
	}
	
	public Book[] searchByPrice(int price) {
		Book[] searchedBooks = new Book[1000];
		int idx = 0;
		
		for(Book item : items) {
			if(item == null)break;
			if(item.getPrice() < price) {
				searchedBooks[idx++] = item;
			}
		}
		return searchedBooks;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public int getAveragePrice() {
		return totalPrice / index;	
				
	}
}
