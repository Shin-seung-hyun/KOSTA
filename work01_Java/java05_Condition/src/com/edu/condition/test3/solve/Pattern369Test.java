package com.edu.condition.test3.solve;

import java.util.Scanner;

public class Pattern369Test {
	public static void solv(int n) {
		//코드 구현
		int start = n/10;
		int end = n%10;
		
		if(start==3 | start==6 | start==9){
			if(end==3 || end ==6 || end==9){
				System.out.println("@@");
				System.exit(0);
			}
			
			System.out.println("@");
		}else if(end==3 || end==6 || end==9){
			System.out.println("@");
		}else{
			System.out.println(n);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2자리 숫자입력 >> ");
		int n = sc.nextInt();
		
		solv(n);
	}
}
