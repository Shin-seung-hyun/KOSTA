package com.edu.oop;

/*
 
클래스의 구성요소 (성질과 행위)
1) 필드(변수) : 클래스의 특징
2) 메소드 : 클래스를 통해서 하는 기능
 
*/


public class Greet {

	//필드 선언
	public String who;
	public String message;
	
	//필드 초기화 : 새로운 값 할당
	public String who2 =" James";
	
	//메소드 정의(선언부 + 구현부)
	// Worker method
	public void sayHello() {
		System.out.println(who + ", " + message);
	} 
	
}
