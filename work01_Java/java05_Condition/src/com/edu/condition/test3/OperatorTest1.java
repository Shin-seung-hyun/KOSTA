package com.edu.condition.test3;

public class OperatorTest1 {

	public static void main(String[] args) {
		
		int i = 5;
		int j = 3;
		
		// % 연산자 : modulus(mod) 나머지
		// / 연산자
		int num = 98;
		System.out.println("십의 자리 / : " + num / 10);
		System.out.println("일의 자리 % : " + num % 10);
		
		
		//++ : 1씩 증가시킬 때 연산자
		//-- : 1씩 감소시킬 때 연산자
		int k =10;

		System.out.println(k++); //10
		System.out.println(k); //11

		System.out.println(++k); //12
		System.out.println(k); //12
		
		
		///////////////same/////////////////
		// o1, o2 는 참조 변수이다.
		// 참조하는 객체의 주소값이 있다.
		// o1,o2는 주소 값이 다르다. Heap에 각각 올라감
		
		// Operator 01 stack에 저장
		// new Operator(); 힙에 올라감
		// 생성자 실행
		// 주소값 생성
		
		Operator1 o1 = new Operator1();
		Operator1 o2 = new Operator1();

		// 주소값 찍어보기
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o1==o2); //false
		System.out.println(o1!=o2); //true
		
		
		/////////////// short circuit (지름길)/////////////////
		/*
		 *   | 연산자
		 *  앞 뒤 모두 연산 후 출력함.
		 *  
		 *  (true) || (??) 연산자는 
		 *  앞의 계산이 true이면 뒤의 연산과 상관 없이 true를 반환
		 *  뒤를 건너 뛴다의 의미
		 *  
		 *  왜 이렇게 쓸까?
		 *  속도때문에 쓴다는 것은 학술적 의미
		 *  뒤를 실행했을 때의 오류/예외 가능성을 줄이기 위함.
		 */
		
		System.out.println("short circuit의 의미를 공부해보자");
		System.out.println(o1.test1() | o1.test2()); // true
		System.out.println("################");
		System.out.println(o1.test1() & o1.test2()); // false
		System.out.println(o1.test2() & o1.test2());
		
		System.out.println("==============");
		System.out.println(o1.test1() || o1.test2());
		System.out.println("==============");
		System.out.println(o1.test2() && o1.test1());
		
		
		/////////////// equals /////////////////
		/*
		 문자열은 == 을 쓰면 안된다.
		 		equals 써야한다.
		 equals 함수는 주소값을 비교를 한다. 
		 			  그러나, String에서는 문자열 비교로 바뀌어서 쓰임.
		 */
		
		System.out.println("========== String equals======== ");
		System.out.println(o1.equals(o2)); 	//false
		System.out.println(o1 == o2);		//false
		
		String msg = "Hello";
		String msg2 = "Hello";
		System.out.println(msg.equals(msg2)); 	// true
		System.out.println(msg == msg2);		// 이렇게 쓰면 안됌
		

	}
}//  OperatorTest1



class Operator1{

	public boolean test1() {
		System.out.println("test1() calling ....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() calling ....");
		return false;
	}
	
} // class Operator


class Operator2{

	public boolean test1() {
		System.out.println("test1() calling ....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() calling ....");
		return false;
	}
	
}








