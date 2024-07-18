package com.edu.array.test;

import com.edu.vo.NoteBook;
import com.edu.vo.Programmer;

public class TonysArrayTest3 {

	public static void main(String[] args) {
		
		NoteBook nb1 = new NoteBook(111, "HP", 150);
		NoteBook nb2 = new NoteBook(222, "LG Gram", 170);
		NoteBook nb3 = new NoteBook(333, "SAMSUNG", 200);
		
	//1) Kate의 설계
//		
//		Programmer kate = new Programmer("kate");
//		
//		kate.buyNoteBook(nb1);
//		kate.buyNoteBook(nb2);
//		kate.buyNoteBook(nb3);
//		
//		kate.getNoteBook().printNoteBookInfo(); //333, HP2, 140.0
		
		
	//2) Bob의 설계	
		Programmer bob = new Programmer("bob");
		
		NoteBook[] noteBooks = {
				new NoteBook(111, "HP", 150),
				new NoteBook(222, "LG Gram", 170),
				new NoteBook(333, "SAMSUNG", 200)
		};
		
		bob.buyNoteBooks(noteBooks);
		System.out.println("Bob's NoteBook Info ========");
		NoteBook[] returns = bob.getNoteBooks();
	
		for( NoteBook nBook : returns) {
			
			System.out.println(nBook.getNoteBookInfo());
		}
		
	}

}
