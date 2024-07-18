package com.edu.vo;

public class Programmer {
	
	
	//생성자 주입
	String name;
	String mainSkill;
	float salary;
	String address;
	int bonus;
	
// Has a Relation
	//setter 주입
	NoteBook noteBook;
	
	public Programmer() {}

	public Programmer(String name, String mainSkill, float salary, String address, int bonus) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
		this.address = address;
		this.bonus = bonus;
	}

	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	
	
	public NoteBook getNoteBook() {
		return noteBook;
	}


	public String getNoteBookInfo() {
		return name +", " + mainSkill +", " + salary;
	}
	

	public float getAnnualSalary() {
		return salary * 12 + bonus;
	}
	
	public void raiseSalary(int amount) {
		 salary += amount;
	}
	

}
