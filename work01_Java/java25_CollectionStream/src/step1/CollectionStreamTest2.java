package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*
 *  Stream 특징
 *  	1) read only : 데이터 소스로 부터 데이터를 읽어들이기만 할뿐 변경사항을 저장하지 않는다.
 *  	2) 일회성 : iterator 처럼 일회성이다. 최종연산이 진행되면 닫힌다.(필요하면 다시 생성해서 써야 한다.)
 *  	3) 지연된 연산 : 최종연산 전까지 스트림의 중간연산이 수행되지 않는다.
 *  	4) 멀티 쓰레드 지원 : 병렬 처리 작업이 가능하다.
 *  		FP(함수형 언어)는 빅데이터를 빠르게 처리하기 위해서 발전된 기술이다. AI와 연결된다.
 *  		그러기 위해서는 직렬적 작업보다는 병렬적 작업으로 대용량 데이터를 효율적으로 처리하는 기술이 필요하다.
 *  
 *  	5) 기본형에 맞는 Stream 이 있다. 또한, 각 자료형에 대한 기능도 많다.
 *  	   	기본형데이터를 다룰 때 우리는 <T> 안에 객체로 바꿔서 사용한다.
 *  	   	Stream<Integer> VS 	IntStream	 
 *  	   	Stream<Double>		DoubleStream
 *  	   	Stream<Long>		LongStream
 *  	   	Stream<Float>		FloatStream
 */

public class CollectionStreamTest2 {

	public static void main(String[] args) {
		
		List<String> fruits = new ArrayList<>();
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Apple");
		fruits.add("Melon");
		fruits.add("Grape");
		fruits.add("Orange");
		fruits.add("Melon");
		fruits.add("Grape");
	
		// 특징 1) read only : 원본 변경 안됨
		System.out.println("\n====================================================");
		System.out.println("원본 리스트1 :: " + fruits);
		Stream<String> stream = fruits.stream(); 
		stream.distinct().limit(3).sorted().forEach(i-> System.out.println(i + " ")); 
		
		System.out.println("원본 리스트2 :: " + fruits);
		
		// 특징 2) 일회성 
		//문자열 배열이 소스인 스트림
		System.out.println("\n====================================================");
		String[] strArr = {"dd","aaa", "cc", "CC", "b"};
		Stream<String> strStream = Stream.of(strArr); // String[]은 Collection이 아님으로 변경
		strStream.forEach(System.out::println);	// 이미 최종 연산을 해서 Stream 요소를 꺼내 쓰고 Stream 을 닫았다.
		
		//long count = strStream.count();
		//System.out.println( "남은 데이터 갯수 : " + count); //[Error]: stream has already been operated upon or closed
														//최종연산을 하면 스트림이 닫히기에 다시 사용할 수 없다.
		
		// 특징 3) 중간연산은 최종연산 전에 같이 된다. 지연된 연산
		System.out.println("\n====================================================");
		IntStream intStream =  new Random().ints(1,46); // 무한 스트림 : 1-45까지의 값을 무한반복한다.
		intStream.forEach(i -> System.out.println( i+ " ")); 
		
		intStream.distinct().limit(6).sorted()
									 .forEach(i -> System.out.println(i +" "));
		
		// 특징 4) 병렬처리 가능
		System.out.println("\n====================================================");
		String[] strArr2 = {"dd","aaa", "cc", "CC", "b"};
		Stream<String> strStream2 = Stream.of(strArr2); 
		
		
		int sum = strStream2.mapToInt(s -> s.length()).sum();
		System.out.println( "모든 문자열의 길이의 합은 : " + sum);
		
		// 위의 작업을 병렬 처리로 만들어 보자 parallel()
		Stream<String> strStream3 = Stream.of(strArr2);
		int sum2 = strStream3.parallel().mapToInt(s -> s.length()).sum();
		System.out.println( "모든 문자열의 길이의 합은 : " + sum2);
		
		
	}
	
}
