package com.edu.vo;

import java.util.List;

public class Author {
	private int authorno;
	private String name;
	private String phone;
	private List<Book> books;
	
	public Author() { }

	public Author(String name, List<Book> books) {
		this.name = name;
		this.books = books;
	}

	public Author(int authorno, String name, String phone, List<Book> books) {
		this.authorno = authorno;
		this.name = name;
		this.phone = phone;
		this.books = books;
	}

	public int getAuthorno() {
		return authorno;
	}

	public void setAuthorno(int authorno) {
		this.authorno = authorno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authorno=" + authorno + ", name=" + name + ", phone=" + phone + ", books=" + books + "]";
	}
	
}
