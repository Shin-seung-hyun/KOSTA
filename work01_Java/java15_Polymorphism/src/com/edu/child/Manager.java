package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Manager extends Employee{

	private String dept;
	

	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name,salary,birthDate);					
		this.dept = dept;
	}
	
	
	public String getDept() {
		return dept;
	}


	public void ChangeDept(String dept) {
		this.dept = dept;
	}


	public String toString() {
		return super.toString() + ", " + dept;
	}
	

}
