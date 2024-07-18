package com.edu.statictest;

/*
 * main이 실행 된다 = 객체 생성 => 생성자 호출 => 필드 Initialization (필드 초기화)
 * 
 * Web에서의 초기화는 중요하다
 * 
 */

public class StaticExamTest3 {
	
	static int i;

	public static void main(String[] args) {
		
		System.out.println("1. main method block..." + i);
	}// main end
	
	//static initialization block(= static 초기화 블락) 
	static {
		i = 300;
		System.out.println("2. static block..." + i);
	}

}//class
