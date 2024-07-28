package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 	Collection : 객체를 저장하는 방법론
 	List | Map | Set | Iterable
 	
 	java8 이후에 함수형 인터페이스를 Hasing 하면서 제공되는 기능이 추가됐다.
	Collection : boolean removeIf(Predicate<? super E> filter)
	List : void replaceAll()
	Map : compute(), forEach(), merge() 등등 
 	
 */
public class FunctionalTest3 {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>(); 
		for(int i=0; i<10; i++) list.add(i);
		
		Map<Integer,String> map = new HashMap<>();
		map.put(111, "Scott");
		map.put(222, "Blake");
		map.put(333, "King");
		
	//1. List 에 담긴 객체를 뽑아서 정보를 출력 
		// 1-1. 이전 방식
		System.out.println("\n0. List 에 담긴 객체를 뽑아서 정보를 출력 ==> iterator()" );
		Iterator<Integer> iterator =  list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		
		// 1-2. 람다식 (함수형인터페이스룰 사용해보자)
		System.out.println("\n1. List 에 담긴 객체를 뽑아서 정보를 출력 ==> forEach()" ); 
		list.forEach(i-> System.out.print(i + " ")); // forEach는 뽑아내는 기능이기에 매개변수가 없는 Consumer 가 들어가야 한다.
													 // 사실상 list 안에 있는 것은 출력하기만 하면 됨으로 다 생략하자
													 // list.forEach(System.out::print)와 같다. 클래스명 :: 함수
		System.out.println();
		
				
		System.out.println("\n2. List에 담긴 값중에서 2의 배수 or 3의 배수를 제거한 후 출력");
		list.removeIf(i-> i%2 == 0 || i%3== 0);
		System.out.println(list);
		
		System.out.println("\n3. List에 모든 값들을 10 곱한다.");
		list.replaceAll(i -> i* 10);
		System.out.println(list);
		
		
	//2. Map 에 담긴 객체를 뽑아서 정보를 출력	
		System.out.println("========================= Map ==========================");
		System.out.println("\n4. Map 에 담긴 모든 key, vale를 뽑아서 정보를 출력 ==> iteraotr()");
		
		Iterator<Integer> it = map.keySet().iterator(); 
		while(it.hasNext()) {
			int key = it.next();
			System.out.println("Key: "+  key + ", Value: "+ map.get(key));
		}
		
		System.out.println("\n5. Map 에 담긴 모든 key, vale를 뽑아서 정보를 출력 ==> forEach()");
		map.forEach( (k,v) -> System.out.println("Key: "+  k + ", Value: " + v));
			
	}
}
