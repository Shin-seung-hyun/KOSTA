package com.edu.condition.test1;

import java.util.Random;

//Formating 출력하기 | 삼항 연산자

public class PrintFormatTest4 {

	public static void main(String[] args) {
		Random r = new Random();
		String result = "";
		
		System.out.println("\n############ Formating ####################");
		System.out.println("========= 큰수 혹은 작은수 =========");
		
		int num = r.nextInt(100); //0-99사이의 정수
		
		if(num > 50) result = "큰수";
		else result = "작은수";
		
		
		// 방법1.
		//프론트 단에서 int + String + int + String 과 같이 매번 명시하는 것은 불편하다.
		//System.out.println(num +"은 " + result + " 이다.");
		
		// 방법2.
		System.out.printf("%d는(은) %s이다.%n", num, result);

		System.out.println("\n############ 삼항 연산자 ####################");
		System.out.println("========= 짝수 혹은 홀수 =========");
		
		
		int num2 = r.nextInt(10); //0-9까지의 수
		
		// 방법1.
//		if( num2 % 2 ==0) result = "짝수";
//		else result = "홀수";
		
		// 방법2.
		result = (num % 2 ==0) ? "짝수" : "홀수";
		
		
		System.out.printf("%d는 %s이다.\n", num2,result);
		
	}

}
