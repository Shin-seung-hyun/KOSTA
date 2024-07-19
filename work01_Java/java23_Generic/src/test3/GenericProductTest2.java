package test3;


/*
 * 제한된 파라미터 타입을 정리해보자
 * :: 
 * 메소드 반환 타입이나. 혹은 메소드 매개변수 타입으로만 가능
 * 클래스 타입에서는 적용될 수 없다.
 * ::
 * <T extends Number> // Number의 제한된 타입으로써만 사용
 * T에 올 수 있는 클래스 타입은 Number의 자식 클래스로
 * Long, Integer, Double ,Float, Byte, Short 이런 값들을 다룰 때 사용된다.
 *
 */


public class GenericProductTest2 {
	
	//제한된 파라미터 타입을 갖는 제너릭 메소드를 정의해보자
	public static <T extends Number> boolean compare(T t1, T t2) {
		
		
		System.out.println("compare ( " + t1.getClass().getSimpleName() +  ", " +
										  t2.getClass().getSimpleName() + " )");
		
		double v1 = t1.doubleValue(); //UnBoxing
		double v2 = t2.doubleValue();
		return v1 == v2;
	}
	
	
	public static void main(String[] args) {
		boolean result = compare(10,20); // Auto Boxing되어 저장됨
										 // doubleValue()에 의해 변환
		System.out.println(result);
		
		boolean result2 = compare(4.5, 4.5); // Auto Boxing되어 저장됨
		 								 // doubleValue()에 의해 변환
		System.out.println(result2);
		
//		boolean result3 = compare('A', 'A'); // (X)
//		System.out.println(result3);
		
	} //local 부분
	
}
