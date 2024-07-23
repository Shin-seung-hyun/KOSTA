package step1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionStreamTest1 {

	public static void main(String[] args) {
		
		//1. 문자열 리스트가 소스인 Stream 생성
		List<String> fruit = new ArrayList<>();
		fruit.add("Banana");
		fruit.add("Apple");
		fruit.add("Apple");
		fruit.add("Melon");
		fruit.add("Grape");
		fruit.add("Orange");
		fruit.add("Melon");
		fruit.add("Grape");
		
		System.out.println("\n================= List =====================");
		Stream<String> stream = fruit.stream(); // 1. list 를 소스로 만들자 , 스트림 생성
		
		//출력 방법1)
		//stream.distinct().limit(3).sorted().forEach(i-> System.out.println(i + " ")); // forEach 내 Consumer가 있음
																					  //forEach()는 최종연산
		
		//출력 방법2)
		List<String> list =  stream.distinct().limit(3).sorted().collect(Collectors.toList()); // 중간연산자의 결과를 수집함 
		System.out.println(list);
		
		System.out.println("\n================= Set =====================");
		Set<String> set = new HashSet<>();
		set.add("이희주");
		set.add("김믿음");
		set.add("이찬영");
		
		Stream<String> stream1 =  set.stream();
		stream1.forEach(s -> System.out.println(s));
	
	
		System.out.println("\n================= Map =====================");
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(111, "이희주");
		map.put(222, "이희주");
		map.put(333, "이희주");
		
		map.forEach( (k,v) -> System.out.println("key : " + k + ", Value : " + v));
	
	}
	
	

}
