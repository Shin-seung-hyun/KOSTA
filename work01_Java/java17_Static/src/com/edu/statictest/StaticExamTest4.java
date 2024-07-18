package com.edu.statictest;

/*
 *Access Modifier :: public < protected < default < private
 *Usage Modifier :: static, final, abstract
 *
 *static + final 주로 함께 쓰인다.(순서는 중요하지 않음)
 */

class A{
	public final static int BASE_SALARY = 4000;
	public final String test() {
		return "Overriding 금지";
	}
}

final class B{ // 상속 금지
	
}

//class C extends B{  // (X) 상속 금지 확인
//
//}

class D extends A{
	
//	@Override			//(x) Overriding 금지
//	public final String test() {
//		return "Overriding 금지";
//	}
}


public class StaticExamTest4 {

	public static void main(String[] args) {
		
		//A.BASE_SALARY = 5000; // (X) 상수값 변경 금지
	}

}
