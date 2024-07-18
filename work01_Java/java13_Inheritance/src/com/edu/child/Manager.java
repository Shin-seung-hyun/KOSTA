package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Manager extends Employee{

	private String dept;
	
//	public Manager() {
//		public Employee(); // = super();
//	}

	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name,salary,birthDate);
		//this.name = name; (X) : 부모의 것을 가져다 써야 한다. 					
		this.dept = dept;
	}
	
	
//	public String getDetails() {
//		//name은 private임으로 직접 접근이 불가능하다..	
//		return super.name + ", " + super.salary;
//	}
	
	public String getDetails() {
		//부모가 물려준 기능을 자식에게 맞게 고쳐쓰자
		//구현부 재정의
		//Method Overriding
		return super.getDetails() + ", " + dept;
	}
	
	
	

}
