package com.edu.test;

import com.edu.child.Airplane;
import com.edu.child.Bird;
import com.edu.parent.Flyer;

public class InterfaceTest1 {

	public static void main(String[] args) {
		
		//Flyer f = new Flyer() {		}; (x)
		// abstract 가 조금이라도 있으면 객체 생성의 대상이 될 수 없다..
		// 대신에 객체 생성을 하기 위한 타입으로 사용하는 것은 가능하다. Flyer f 는 가능
		
		Flyer f = new Bird(); //Polymorphism
	
		// 부모 타입으로 자식 객체를 생성하면 2가지 현상 발생
		// 1. Object Casting
		// 2. Virtual Method Invocation
		System.out.println(((Bird)f).layEggs()); //1. 
		f.land(); //2.
		
		
		 Flyer f2 = new Airplane();
		 
		 f2.fly();	 //2. 부모 객체로 부르지만 자식 객체가 실행된다
		 f2.land();	 //2. 
	
		 
		 Flyer[] f3 = new Flyer[3];	// 타입으로서 생성 가능
	}

}
