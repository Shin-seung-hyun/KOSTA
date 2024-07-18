package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 	필드에 직접 할당하지 않고,
 	setXXX(o,o,o) 기능을 호출해서 필드 초기화를 구동.
 */
public class NoteBookAppTest2 {

	public static void main(String[] args) {
		
		//객체 생성 코드
			//묵시적 초기화 진행
		NoteBook n = new NoteBook();
		
		n.setNoteBookField(123, "LG Gram", 1_700_000);
		//n.printNoteBookInfo();
		
		System.out.println(n.getNoteBookInfo());
	
	}

}
