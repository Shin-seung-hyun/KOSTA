package com.edu.parent;


/*
 * 인터페이스는 추상 메소드들의 집합 + public static final 상수값
 * 
 * public abstract 메소드와 public static final 상수값으로 구성됨
 * Template 기능 위주의 모듈
 */
public interface Flyer {

	int MAX_SPEED = 200;	 //public static final이 생략 가능
	void fly();
	void land();			//public abstact 생략 가능(인터페이스이기에)
	void take_off();
}
