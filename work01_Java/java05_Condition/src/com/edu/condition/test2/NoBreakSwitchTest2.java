package com.edu.condition.test2;

//Break를 사용하지 않을 때
public class NoBreakSwitchTest2 {

	public static void main(String[] args) {
		
		//8시~ 11시 사이의 임의의 값이 할당되도록 로직을 작성
		int time = (int)(Math.random()*4) + 8;
		System.out.println("[현재시간 : " + time + "시]");
		
		switch(time) {
		case 8:
			System.out.println(time + "출근 준비합니다.");
		case 9 :
			System.out.println(time + "회사 도착");
		case 10:
			System.out.println(time + "오전 업무합니다.");
		case 11 :
			System.out.println(time + "외근 합니다.");
		}

	}

}
