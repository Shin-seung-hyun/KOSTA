package com.edu.condition.test3.solve;

import java.util.Scanner;

public class CatchAMouseTest {
	public static String solv(int x, int y, int z) {
		if(Math.abs(x-z)> Math.abs(y-z)) {
			return "CatB Catch!";
		}else if(Math.abs(x-z)< Math.abs(y-z)) {
			return "CatA Catch!";
		}else {
			return "Mouse Escapes!!";
		}		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("CatA, CatB, Mouse 위치를 숫자로 입력 >>> ");
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
		String result=solv(catA, catB, mouse);
		System.out.println(result);

	}

}
