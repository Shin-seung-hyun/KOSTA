package com.edu.array.test1;

import java.util.Scanner;

/*
	 Scanner를 사용해서 맨 처음 입력받는 값으로 배열의 크기를 받아오자
	 
	 int size  = sc.nextInt();
	 
 */
public class BasicArrayTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열의 사이즈 입력 >>");
		int size = Integer.parseInt(sc.nextLine());
		
		System.out.println("String 타입의 배열을 생성");
		String[] names = new String[size];
		
		System.out.println("String 타입의 배열 초기화");
		for(int i=0; i<size; i++) {
			//names[i] = sc.next();
			names[i] = sc.nextLine();
		}
		
		System.out.println("이름들을 출력");
		for(String name : names) {
			System.out.print(name + " ");
		}
		
	}

}
