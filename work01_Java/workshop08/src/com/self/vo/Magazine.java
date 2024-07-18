package com.self.vo;

import com.self.util.Date;

public class Magazine extends Book{
	
	private Date pubDate;
	

	public Magazine(int isbn, String title, String author, String publisher, double price, Date pubDate) {
		super(isbn,title,author,publisher,price);
		this.pubDate = pubDate;
	}

	public Date getPubDate() {
		return pubDate;
	}
	
	@Override
	public String toString() {
		return super.toString() +", " + pubDate;
	}

}
