package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*
 * 스트림 만드는 작업과정
 * 1. stream 생성 .stream()
 * 2. 중간 연산자
 * 3. 최종 연산자
 * 
 */
public class CollectionStreamTest4 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);

		System.out.println("==================== 1. 스트림은 일회성이다. ========================");
		//1. stream 생성
		Stream<Integer>intStream =  list.stream();
		
		//3. 최종 연산
		intStream.forEach(System.out::print);
		//intStream.forEach(System.out::print); // error 발생 : 이미 stream 은 닫혔다(위에서 최종연산을 이미했다.)
		
		System.out.println();
		intStream = list.stream();	// 다시 새로운 스트림을 연다.
		intStream.forEach(System.out::print);
		
		System.out.println("\n\n===========================================================");
		Stream<Integer> intStream2 = Stream.of(1,2,3,4,5);
		System.out.println("intStream2 count : " + intStream2.count());
		
		Stream<Integer> intStream3 = Stream.of(1,2,3,4,5);
		//System.out.println("intStream3 sum : " + intStream3.sum()); // ERROR : The method sum() is undefined for the type Stream<Integer>
																	// sum 기능은 없다. IntStream에 있다.
																	// 숫자 전용 Stream 이 아니기에 String, Employee 여러 타입이 들어갈 수 있다.
																	// 따라서 count, sum, average 가 있는 IntStream 을 쓰자
		
		System.out.println("\n\n================== IntStream ===============================");
		int[] intArr = {1,2,3,4,5};
		IntStream intStream4 = Arrays.stream(intArr);
		
		//intStream4.forEach(System.out::print);
		//System.out.println(intStream4.sum());
		//System.out.println(intStream4.average());
		System.out.println(intStream4.findFirst());

	}
	
}
