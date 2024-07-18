package com.edu.condition.test1;

import java.util.Scanner;

import javax.print.DocFlavor.BYTE_ARRAY;

/*
 * GradeIfTest1 코드는 컴파일 시점에 실제값 88이 입력되는 코드
 * 실행 시점에 값이 입력되도록 Scanner를 생성해서 값을 입력받아 보자
 * 
 * 입력 : 학생이름/ 해당 학생의 점수
 * 출력 : 
 * 		하승현, C Grade 출력이 되도록 로직을 추가
 */


public class GradeIfTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신의 이름과 성적을 입력하세요");
		String name = sc.nextLine();
		int grade = sc.nextInt();
		
		if(grade >= 90 & grade <= 100) {
			System.out.println(name + ", A grade");
		}
		else if(grade >= 80 & grade < 90) {
			System.out.println(name + ", B grade");
		}
		else if(grade >= 70 & grade < 80) {
			System.out.println(name + ", C grade");
		}
		else {
			System.out.println(name + ", Try again");
		}
		
		
		
		

	}

}
