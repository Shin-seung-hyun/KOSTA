package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 1. NoteBook 클래스의 객체를 생성
 	= NoteBook의 멤버(4개)를 메모리에 올린다.
 2. 접근
 	필드 접근 : 값 할당
 	메소드 접근 : 호출
 	 
 */
public class NoteBookAppTest {

	public static void main(String[] args) {
		
		//객체 생성 코드
			//묵시적 초기화 진행
		NoteBook n = new NoteBook();
		
		//명시적 초기화
		n.serialNumber = 111;
		n.brand = "LG Gram";
		n.price = 1_700_000.0;
		
		n.printNoteBookInfo();
		
		System.out.println(n); 	// 주소값 print
								//com.edu.oop.NoteBook@27ddd392
								//= com.edu.oop.NoteBook의 위치가 @27ddd392이다.
		
		
		NoteBook n2 = new NoteBook();
		
		n2.serialNumber = 222;
		n2.brand ="Samsung";
		n2.price = 1_350_000;
		
		n2.printNoteBookInfo();
		
		System.out.println(n2);
		
		n = n2;
		
		System.out.println(n);
	}

}
