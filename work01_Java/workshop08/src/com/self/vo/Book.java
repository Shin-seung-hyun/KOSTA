package com.self.vo;

public class Book {
	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private double price;
	
	public Book() {}
	public Book(int isbn, String title, String author, String publisher, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;	//작가
		this.publisher = publisher;	//출판사
		this.price = price;
	}
	
	public int getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public double getPrice() {
		return price;
	}
	public void ChangePrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return isbn +", " + title +", "+ author +", " + publisher +", " + price;
	}

}
