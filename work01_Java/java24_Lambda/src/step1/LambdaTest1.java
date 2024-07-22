package step1;

/*
 *  람다, 람다식
 *  = 함수형 프로그래밍
 *  
 *  java8부터 함수형 프로그래밍인 Lambda 식을 제공하기 시작
 *  
 *  특징
 *  1) 익명함수로 함수의 이름이 없다.
 *  2) 코드가 간결하고, 성능적으로 불리한 부분이 있다.
 *  3) 병렬 처리가 가능하다.
 */

/*

 <일반적인 함수 형식>
	 public int max(int a , int b){
	  	return a>b? a : b; 
	 }

<람다식> 매개변수 -> 처리부분
	(int a , int b) -> { return a>b? a : b;}
	(int a, int b) -> a>b? a: b; (return 은 생략 가능 ;은 생략 안됨)
	(a,b) -> a>b? a: b; 
	a -> a*100;
	
-------------------------------------------------------------------

@FunctionalInterface 의 구현체를 우리는 람다식으로 만들어야 한다.
그렇기 때문에 @FunctionalInterface 는 단 하나의 추상메소드만 가져야 한다.


*/ 

@FunctionalInterface
interface MyFunction{ // 추상메소드가 있어야 한다.
	
	//public abstract int max(int a, int b);
	int max(int a, int b); // 더 큰 수 반환하는 기능의 Template
}
 
public class LambdaTest1 {

	public static void main(String[] args) {
		
		//1. 익명클래스로 구현해보고, 2.람다식을 이해해 보자
		//1. 익명 클래스로 구현
		MyFunction f = new MyFunction() {
			
			@Override
			public int max(int a, int b) {
				return a > b? a : b;
			}
		};
		
		int result = f.max(5,3);
		System.out.println(result);
		
		//2. 람다식으로 구현 (매개변수 -> 구현부);
		MyFunction f2 = (a,b) -> a>b?a:b;
		
		int result2 = f2.max(5, 3);
		System.out.println(result2);
		
		
	}

}
