package com.edu.vo;

public class Book {
	private String isbn;
	private String title;
	private int authorno;
	private String publisher;
	private int price;
	private String description;
	
	public Book(String title, String publisher, int price) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.price = price;
	}
	public Book(String isbn, String title, int authorno, String publisher, int price, String description) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.authorno = authorno;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
	}
	public Book() {
		super();
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthorno() {
		return authorno;
	}
	public void setAuthor(int author) {
		this.authorno = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + authorno + ", publisher=" + publisher
				+ ", price=" + price + ", description=" + description + "]";
	}
	
	
}    
