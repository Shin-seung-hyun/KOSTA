package com.edu.vo;

/*
  Programme가 여러 대의 NoteBook을 구매하기 위해서는 
  반드시 필드에 NoteBook 타입이 아닌
  NoteBook 타입의 배열이(NoteBook[]) 선언되야 한다.
 */
public class Programmer {
	
	
	//생성자 주입
	String name;
	
	//NoteBook noteBook;

	 NoteBook noteBooks[];
	
	public Programmer() {}

	public Programmer(String name) {
		this.name = name;
	}
	
	
	public NoteBook[] getNoteBooks() {
		return noteBooks;
	}

	public void buyNoteBooks(NoteBook[] noteBooks) {
		this.noteBooks = noteBooks;
	}

//	public void buyNoteBook(NoteBook noteBook) {
//		this.noteBook = noteBook;
//	}
//	
//	
//	public NoteBook getNoteBook() {
//		return noteBook;
//	}
	

}
