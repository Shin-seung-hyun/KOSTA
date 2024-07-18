package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Engineer extends Employee {
	
	private String tech;
	private int bonus;
	

	public Engineer(String name, double salary, MyDate birthDate, String tech, int bonus) {
		super(name, salary, birthDate);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	
	public String getTech() {
		return tech;
	}

	public void ChangeTech(String tech) {
		this.tech = tech;
	}

	public int getBonus() {
		return bonus;
	}

	public void ChangeBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString()+ ", " + tech + ", " + bonus;
	}


	
	
}
