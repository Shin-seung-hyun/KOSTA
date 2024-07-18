package com.edu.vo;

import com.edu.util.MyDate;

public class SalesMan {
	private String name;
	private double salary;
	private int commition; //보너스
	private MyDate birthDate;
	
	public SalesMan(){}

	public SalesMan(String name, double salary, int commition, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.commition = commition;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void changeSalary(double salary) {
		this.salary = salary;
	}

	public int getCommition() {
		return commition;
	}

	public void setCommition(int commition) {
		this.commition = commition;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public String getDetails() {
		return name +", " + salary +", " + commition;
	}
	
	
}
