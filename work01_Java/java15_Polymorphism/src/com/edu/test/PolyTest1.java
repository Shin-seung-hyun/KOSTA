package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest1 {
	public static void main(String[] args) {

		Manager m = new Manager("James", 30000.0, new MyDate(1999,1,1), "IT");
		Engineer eg = new Engineer("Tomas", 45000.0, new MyDate(1997,3,12), "Java",100);
		Secretary s = new Secretary("Peter",35000.0,new MyDate(2000,4,3),"James");
		
		m.ChangeDept("기획부");
		eg.ChangeTech("Python");
		s.ChangeNameOfBoss("Jane");
		
		System.out.println(m.toString());
		System.out.println(eg.toString());
		System.out.println(s.toString());
		
		
		System.out.println("=========== Polymorphism ==========");
		//부모타입으로 다양한 자식객체 생성
			//1. Object casting : 부모타입으로 자식객체를 생성하고, 자식만의 멤버를 사용하려면 반드시 자식클래스로 Casting 해서 자식만의 멤버에 접근해야 한다.
			//2. Virtual Method Invocation의 원리
		Employee m2 = new Manager("James", 30000.0, new MyDate(1999,1,1), "IT");
		Employee eg2 = new Engineer("Tomas", 45000.0, new MyDate(1997,3,12), "Java",100);
		Employee s2 = new Secretary("Peter",35000.0,new MyDate(2000,4,3),"James");
	
	//1.Object Casting	
		//Manager타입으로 불러서 메소드를  찾아야 함. => Object casting
		//메모리에 Manger 타입이 있는데 부모타입이어서 못찾는 것이다. 따라서 타입 변경이 필요하다.
		//m2.changeDept(""); (X)
		
		//Casting 방법1)
		//Manager ma2 = (Manager)m2;
		//ma2.ChangeDept("교육부");
		
		//Casting 방법2)
		((Manager) m2).ChangeDept("교육부");
		
	//2. Virtual Method Invocation의 원리
		//상속 관계에 있는 두 개의 클래스 사이에서 부모 타입으로 자식 객체를 생성하고, 
		//부모 타입으로 overriding된 자식의 메소드를 호출하면 발생하는 원리이다.
		/*
		 * 컴파일 시점의 메소드(부모의 메소드 호출)와
		 * 실행 시점의 메소드(실질적으로 생성된 자식의 메소드 호출)가 다른 원리를 말한다.
		 * 
		 */
		System.out.println(m2.toString()); //James, 30000.0, 1999-1-1, 교육부
		
		
		//eg2 엔지니어의 기술을 AI로 변경, 보너스도 300달러로 변경
		//정보를 출력해서 확인
		
		((Engineer)eg2).ChangeTech("AI");
		((Engineer)eg2).ChangeBonus(300);
		
		System.out.println(eg2.toString());
		
	}

}
