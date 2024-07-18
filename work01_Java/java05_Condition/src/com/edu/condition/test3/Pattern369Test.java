package com.edu.condition.test3;

import java.util.Scanner;


public class Pattern369Test {
	
	
	public static void solv(int number) {
		
		String str = "";
		int tenDigit = number / 10;
		int oneDigit = number % 10;
		
		if( tenDigit % 3 == 0) {
			
			str += "@";
			if( oneDigit % 3 == 0) str += "@";

		}
		else {
			
			if( oneDigit %3 == 0) str += "@";
			else {
				System.out.println(number);
				System.exit(0);
			}
			
		} 
		
		System.out.println(str);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("두자리 숫자 입력 >> ");
		int n = sc.nextInt();
		
		solv(n);

	}

}
