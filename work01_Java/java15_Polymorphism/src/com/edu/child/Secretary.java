package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Secretary extends Employee{
	
	public String nameOfBoss;

	
	public Secretary() {}
	public Secretary(String name, double salary, MyDate birthDate, String nameOfBoss) {
		super(name, salary, birthDate);
		this.nameOfBoss = nameOfBoss;
	}
	
	public String getNameOfBoss() {
		return nameOfBoss;
	}
	
	public void ChangeNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", [nameOfBoss] : " + nameOfBoss;
	}
	

}
