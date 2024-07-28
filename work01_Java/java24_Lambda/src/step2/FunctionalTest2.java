package step2;

import java.util.function.Predicate;

/*
	Predicate 의 결합
	default method : and(), or(), negate() 2개를 사용해서 하나의 Predicate 로 결합 가능하다.
	
	햠수형 인터페이스는 추상메소드 하나를 무조건 가진다.
	그리고 그 외에도 다른 메소드를 가질 수 있다.
	1) 추상메소드 단 1개
	2) static 메소드
	3) default 메소드
	
	하지만 핵심은 추상메소드!
 */
public class FunctionalTest2 {

	public static void main(String[] args) {
		
		
		Predicate<Integer> p = i -> i<100; //100보다 작은 수 
		Predicate<Integer> q = i -> i<200; //200보다 작은수
		Predicate<Integer> r = i -> i%2 ==0; //짝수
		
		
		//default 함수의 결합으로 만들어보자
		Predicate<Integer> notP = p.negate(); //i >=100
		Predicate<Integer> all = notP.and(q).or(r); // i >=100 && i<200 || i%2 ==0 
		Predicate<Integer> all2 = notP.and(q.or(r)); // i >=100 && (i<200 || i%2 ==0)
		
		//Predicate 를 사용할 땐 추상메소드 test() 를 사용한다.
		System.out.println(all.test(2));	 //true
		System.out.println(all2.test(2));	 //false
		
	}
}
