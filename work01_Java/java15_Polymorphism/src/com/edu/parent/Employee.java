package com.edu.parent;

import com.edu.util.MyDate;

//부모 클래스
public class Employee {
	private String name;
	private double salary;
	private MyDate birthDate;
	
	public Employee() {}
	
	public Employee(String name, double salary, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getDetails() {
		
		//1) X :birthDate.toString()이 생략된 것으로 주소값이 출력된다.
		//return name +", " + salary +", " + birthDate; // "James, 30000.0, com.edu.util.MyDate@6504e3b2"
		
		//2) O : 날짜가 잘 출력된다.
		return name +", " + salary +", " + birthDate.getDate(); //James, 30000.0, 1999-1-1, IT
	}
	
	
}
