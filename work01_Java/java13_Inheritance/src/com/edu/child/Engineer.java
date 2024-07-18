package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Engineer extends Employee {
	
	//기본적으로 Employee의 멤버를 물려받는다.
	//따라서 자기 자신만의 멤버만 추가하면 된다.
	private String tech;
	private int bonus;
	
	//명시적 생성자 추가
	public Engineer(String name, double salary, MyDate birthDate, String tech, int bonus) {
		super(name, salary, birthDate);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	
	//step1. 부모가 물려준 기능을 받아서 (선언부는 그대로)
	//step2. 자신에게 맞게 고쳐쓴다. Method overriding (구현부는 수정)
	
	@Override
	public String getDetails() {
		return super.getDetails()+ ", " + tech + ", " + bonus;
	}


	
	
}
