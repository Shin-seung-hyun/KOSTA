package com.edu.test;

import com.edu.child.Manager;
import com.edu.util.MyDate;

public class Inheritance {
	public static void main(String[] args) {

		Manager m = new Manager("James", 30000.0, new MyDate(1999,1,1), "IT");
	
		//부모의 getDetails를 재정의
		System.out.println(m.getDetails());
		
	}

}
