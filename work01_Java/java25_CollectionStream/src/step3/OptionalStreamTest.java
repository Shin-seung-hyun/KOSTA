package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

/*
 
 Optional 클래스는 java8에 추가된 기능으로 값이 존재하지 않는 경우(null) 을 다루는데 사용된다.
 이 클래스는 값이 있을 수도 반환받지 못하는 상황을 중재한는 일종의 컨테이너 역할을 한다.
 따라서 NullPointerExcepion 발생을 방지하는 효과가 있다.
  
 */
public class OptionalStreamTest {

	public static void main(String[] args) {

		
		List<Integer> list = new ArrayList<Integer>(); // 값이 없는 리스트 생성
		
		
		//예외발생
		// java.util.NoSuchElementException: 
		//이런 경우에 Optional 이 필요하다.
//		double avg= list.stream()
//						.mapToInt(i -> i.intValue())
//						.average()
//						.getAsDouble();
//		System.out.println(avg); 
//	
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);
		double avg2= list2.stream()
						.mapToInt(i -> i.intValue())
						.average()
						.getAsDouble();
		System.out.println(avg2);
		
		
		// 방법 1.
		OptionalDouble optional= list.stream()
									//.mapToInt(i-> i.intValue()) // i는 Integer 클래스 i.intValue()는 Integer 클래스의 메소드이다.
									.mapToInt(Integer :: intValue)
									.average();
		
		if(optional.isPresent()) System.out.println("방법 1_평균 : " + optional.getAsDouble());
		else System.out.println("방법 1_평균 : 0.0 ");
		
		
		
		// 방법 2.
		double avg= list.stream()
						.mapToInt(Integer :: intValue)
						.average()
						.orElse(0.0);
		System.out.println("방법 2_평균 : " + avg);
		
		
		// 방법 3.
		list.stream()
		.mapToInt(Integer :: intValue)
		.average()
		.ifPresent(i -> System.out.println("방법 3_평균 : " + i)); // 값이 있을 때만 출력함, 값이 없으면 출력도 안함.
		
		
	}

}
