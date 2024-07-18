package com.self.util;

public class Date {
	private int year;
	private int month;
	
	public Date(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}

	public String toString() {
		return year+"-"+month;
	}

}
