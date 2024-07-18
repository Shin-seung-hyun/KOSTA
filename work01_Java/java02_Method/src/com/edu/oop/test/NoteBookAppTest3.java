package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*

 생성자 : 객체가 생성될 때마다 구동되는 것
*/
public class NoteBookAppTest3 {

	public static void main(String[] args) {
		
		//객체 생성 코드
		//묵시적 초기화 진행
		NoteBook n = new NoteBook();
		NoteBook n2 = new NoteBook(999, "samsung", 2_200_000);
		
		System.out.println(n.getNoteBookInfo());
		System.out.println(n2.getNoteBookInfo());

	}

}
