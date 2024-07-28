package step1;

/*
	LdmdbaTest2에서 기능의 매개변수로 인터페이스를 주입했다.
	훨씬 더 간단한 코드로 다시 작성해보자
	
	추상메소드의 4가지 패턴
	@FunctionalInterface
		0. 매개변수 X, 반환타입 X // 잘 안쓰임 Runnable void run()
		1. 매개변수 O, 반환타입 X
		2. 매개변수 X, 반환타입 O 
		3. 매개변수 O, 반환타입 O
		4. 매개변수 O, 반환타입이 boolean
 */


@FunctionalInterface
interface Calculable{	
	
	// 1. 매개변수 O, 반환타입 X 인 경우( 매개변수 2개, 반환타입 0개)
	void calculate(int a ,int b); 
}

public class LambdaTest4 {
	
	//2. static 메소드의 매개변수로 Hasing
	public static void action(Calculable cal) { 	
		
		System.out.println("action...method");
		int a = 11;
		int b = 22;
		
		cal.calculate(a, b);
	}
	
	public static void main(String[] args) {
		
		//1. 람다식 함수형 인터페이스 사용
		Calculable c = (x,y) -> System.out.println( x + y);	 // @Override calculate
		c.calculate(10, 20);													
		
		//2-1.
		System.out.println();
		action((x,y) -> {				// @Override calculate
			int result = x + y;
			System.out.println(result);
		});
		
		//2-2. 재사용성이 뛰어남
		System.out.println();
		action((x,y) -> System.out.println(x * y)); // @Override calculate
		
	}
	
}
