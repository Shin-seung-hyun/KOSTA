package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 중간처리 연산자를 공부해보자
	// java.util.stream 내 stream 클래스
public class Stream02ProcessMethod {

	public static void main(String[] args) {
		
		System.out.println("======= 1. 중간 처리 연산자를 잘못 사용하는 경우 ======");
		int[] intArr = {1,2,3,4,5};
		Arrays.stream(intArr)
						.filter(i -> i%2==0)
						.peek(System.out::print); //최종처리 연산이 없으면 출력이 안됨(중간연산자는 지연된 연산을 한다)
		
		
		System.out.println("\n======= 2. 중간 처리 연산자를 peek()을 올바르게 사용하는 경우 ======");
		int sum = Arrays.stream(intArr)
						  .filter(i -> i%2==0)
						  .peek(i-> System.out.print(i + " "))
						  .sum(); // 최종처리
		System.out.println("\nResult : " + sum);
		
		
		
		System.out.println("\n======= 3. 중간 처리 연산자를 올바르게 사용하는 경우 ======");
		int sum2 = Arrays.stream(intArr)
						.filter(i -> i%2==0)
						.sum();
		System.out.println(sum2);
		
		
	}

}
