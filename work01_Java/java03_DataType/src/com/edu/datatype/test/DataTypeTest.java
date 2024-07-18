package com.edu.datatype.test;

public class DataTypeTest {

	public static void main(String[] args) {
		
		//값의 range 비교
		float salary = 100;
		System.out.println(salary);
		
		// 데이터 타입 비교
		//float salary2 = 100.0;	// error 발생
		System.out.println(salary);
		
		short a = 1;
		short b =2;
		
		short c  =  (short)(a + b);
		
		
		int x = 24;
		//byte y = x;
		
		byte z = 24;
		
		
//		Long, float, double 은 값 뒤에 데이터 타입이 지정된 값이다. 생략돼 안보이는 것이다.
//		실수의 경우 기본 값이 double 임으로 원래 100.0d이 저장된 것이다.
//		따라서 float salary2 = 100.0d; 인 것이다.
//		즉, float salary2 = 100.0f; 로 바꿔야 함.
		
		//int 이하의 사칙연산에서는 int형으로 변환된다. 
//		

	}

}
