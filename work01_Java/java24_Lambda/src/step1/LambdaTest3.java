package step1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest3 {

	public static void main(String[] args) {
		
		List<Integer> list =  Arrays.asList( 100, 45, 200, 33, 44, 3, 1, 99);
		
		Collections.sort(list);
		System.out.println(list);
		
	//내림차순 정렬 or 커스터마이징
		//1. 익명 클래스를 사용한 것
//		Collections.sort(list, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2- o1;
//			}
//			
//		});
		
		//2. 람다식 사용
		Collections.sort(list, (o1,o2) -> o2-o1);
		System.out.println(list);
	}
	
}
