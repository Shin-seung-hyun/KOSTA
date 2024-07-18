package com.edu.oop;

/*
 노트북의 정보를 저장하고 있는 클래스
 
*/
public class NoteBook {
	
	//field 선언
	public int serialNumber;
	public String brand;
	public double price;
	
	//기본 생성자 default
	//생성하지 않으면 compiler 만들어줌

	public NoteBook(){};
	
	//명시적 생성자 (setter 기능과 동일함)
	public NoteBook(int serialNumber, String brand, int price) { 

		// 필드 내용 초기화
		this.serialNumber= serialNumber;
		this.brand = brand;
		this.price = price;
	}

	
	//필드에 값을 할당, 주입, setter(inject)
	public void setNoteBookField(int serialNumber, String brand, double price) {
		
		//필드 초기화
			//필드와 지역변수의 변수명이 같을 때, 구분하기 위해 필드 앞에 this를 지정
			//this 는 해당 객체의 주소값을 참조하고 있다.
		this.serialNumber= serialNumber;
		this.brand = brand;
		this.price = price;
		
	}
	
	
	//필드에 주입된 값을 받아옴, getter, reading
		//String 과 nonString이 concat되면 String으로 convert 됨 
	public String getNoteBookInfo() {
		
		return serialNumber + ", " + brand +", " + price;
	}
	
	
	
	//method 정의 = 선언 + 구현
		//void : 반환타입, 해당 기능을 수행한 후 반환값이 없음을 의미
	public void printNoteBookInfo() {
		
		System.out.println(serialNumber +", " + brand +", " + price);
		
	}
	

	
}
