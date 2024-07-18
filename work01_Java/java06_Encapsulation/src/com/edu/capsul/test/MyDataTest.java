package com.edu.capsul.test;

import java.util.Scanner;

import com.edu.capsul.MyDate;

public class MyDataTest {

	public static void main(String[] args) {
		
		MyDate mDate  = new MyDate();
		
		// Invalid value 
			//외부에서 필드에 직접적으로 접근하면 
			//검사를 거치지 않고 바로 DB에 저장됨으로 구제 방법이 없어서 문제가 됨
			//이런 현상이 발생하지 않도록 하는 것이 encapsulation
//		mDate.month = 13;
//		mDate.day = 33;
		
		//System.out.println("Today is " + mDate.getMonth()+"월 " + mDate.getDay() + "일");
		

		//Encapsulation
			// MyData.java 내 public 필드를 private으로 변경 시 is not visible error 발생
			// cannot be resolved or is not a field error가 아니라 있지만 보이지 않는다.
			// set 메소드에서 필드 초기화 직전에 조건을 작성해 DB를 보호한다.
		
//		mDate.setMoth(13);
//		mDate.setDay(33);
		
		
		// 월에 따라 날짜가 결정되는 프로그램
		Scanner scanner = new Scanner(System.in);
		System.out.println("월 입력 >> ");
		int month = scanner.nextInt();
		
		System.out.println("일 입력 >>");
		int day = scanner.nextInt();
		
//		mDate.setMonth(month);
//		mDate.setDay(day);		
		
		mDate.setMonthDay(month, day);
		
		System.out.println("Today is " + mDate.getMonth()+"월 " + mDate.getDay() + "일");
		
	}

}
