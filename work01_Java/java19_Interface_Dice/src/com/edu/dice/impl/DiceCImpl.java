package com.edu.dice.impl;

import java.util.Random;

import com.edu.dice.Dice;

public class DiceCImpl implements Dice{
	
	private int value;
	
	
	//Setter로 주입 or 생성자로 주입 선택
	public DiceCImpl() {
		System.out.println(":: " + getClass().getName() + "기본 생성자...");
	}

	public DiceCImpl(int value) {
		System.out.println(":: " + getClass().getName() + "명시적 생성자...");
		this.value = value;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void selectedNumber() { //Setter의 기능
		value = new Random().nextInt(6) + 1;
	}
	

}
