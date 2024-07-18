package com.edu.child;

import com.edu.parent.Flyer;

public class Bird implements Flyer{

	/*
	 * 상속이기에
	 * 1. void fly()를 물려받는다.
	 * 2. public void fly(){} Overriding 해야 한다.
	 */
	
	@Override
	public void fly() {
		System.out.println("Bird fly...");
	}

	@Override
	public void land() {
		System.out.println("Bird land...");
	}

	@Override
	public void take_off() {
		System.out.println("Bird take_off...");
	}

	//자식만의 멤버 추가
	public String layEggs() {
		return "새가 알을 낳다";
	}
	
	public String buildNest() {
		return "둥지를 짓다";
	}
	
}
