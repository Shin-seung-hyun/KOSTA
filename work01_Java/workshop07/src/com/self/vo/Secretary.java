package com.self.vo;

import com.self.util.MyDate;

public class Secretary extends Employee {
	private String nameOfBoss;
	
	public Secretary(String name, MyDate birthDate, double salary, String nameOfBoss) {
		super(name, birthDate, salary);
		this.nameOfBoss = nameOfBoss;
	}

	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void setNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails() + ", " + nameOfBoss;
	}
	
}
