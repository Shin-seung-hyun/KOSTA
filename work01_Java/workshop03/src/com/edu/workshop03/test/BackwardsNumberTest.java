package com.edu.workshop03.test;

import java.util.Scanner;

public class BackwardsNumberTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("\n1이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();
		
			if( num  >= 1) {
				
				for(int i = num; i>0; i--)
					System.out.print(i + " ");
				
				break;
			}
			else {
				System.out.println("1이상의 숫자를 입력하세요.");
			}
		}
	
		
	}
}
