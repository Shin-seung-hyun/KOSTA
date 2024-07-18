package com.edu.condition.test1;

/*
 * switch문의 문법

	switch(조건에 해당하는 변수){
 		 
 		 case 95 :
 		 case 90 :
 		  	//실행문
 		  	break;
 		 
 		 case 80 : 
 		 case 85 :
 		 	//실행문
 		 	break;
 		 
 		 default : 
 		 	//어느 비교 패턴과도 일치하지 않았을 때 실행할 구문
 
 	}
 	
 	switch의 break;는 해당 case + switch문 까지 빠져나감
 
 */
public class GradeSwitchTest3 {

	public static void main(String[] args) {
		
		int grade = 90;
		
		switch(grade) {
		case 95:
		case 90 :
			System.out.println("A Grade~~");
			break;
		case 85:
		case 80 :
			System.out.println("A Grade~~");
			break;
		case 75:
		case 70 :
			System.out.println("A Grade~~");
			break;
		
		default:
			System.out.println("Try again");
		}
		
		

	}

}
