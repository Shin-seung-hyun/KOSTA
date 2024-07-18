package com.edu.vo;


public class NoteBook {
	
	public int serialNumber;
	public String brand;
	public double price;

	public NoteBook(){};
	
	public NoteBook(int serialNumber, String brand, int price) { 

		this.serialNumber= serialNumber;
		this.brand = brand;
		this.price = price;
	}

	
	public void setNoteBookField(int serialNumber, String brand, double price) {
		
		this.serialNumber= serialNumber;
		this.brand = brand;
		this.price = price;
		
	}
	
	
	public String getNoteBookInfo() {
		
		return serialNumber + ", " + brand +", " + price;
	}
	
	

	public void printNoteBookInfo() {
		
		System.out.println(serialNumber +", " + brand +", " + price);
		
	}
	

	
}
