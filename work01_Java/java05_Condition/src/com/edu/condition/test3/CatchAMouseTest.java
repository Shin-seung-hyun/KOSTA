package com.edu.condition.test3;

import java.util.Scanner;

public class CatchAMouseTest {
	
	
	public static String solv(int a, int b, int m) {
		
		String str = "";
		int intervalA = Math.abs(a - m);
		int intervalB = Math.abs(b - m);
		
		if( intervalA > intervalB) str = "CatB Catch!";
		else if(intervalA < intervalB) str = "CatA Catch!";
		else str = "Mouse Escapes!!";
		
		return str;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
		System.out.println(solv(catA, catB, mouse));

	}

}
