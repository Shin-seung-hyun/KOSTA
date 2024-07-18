package com.edu.collection2;

import java.util.HashMap;

import com.edu.vo.Customer;

public class HashMapTest3 {

	public static void main(String[] args) {
		
		HashMap<String,Customer> map = new HashMap<>();
		
		map.put("111", new Customer("111", 20, "AAA"));
		map.put("222", new Customer("111", 22, "BBB"));
		map.put("333", new Customer("111", 33, "CCC"));

		//1. map에 있는 사람중 222인 사람 찾기
		System.out.println(map.get("222")); 	// list는 get을 idx 중심, map은 key를 중심이기에 get을 쓴다.
		
		//2. 이름이 CCC인 사람을 찾아서 그 사람의 나이를 콘솔로 출력 // value의 값의 
//		for( String ssn : map.keySet()) {
//			
//			Customer c = map.get(ssn);
//			
//			if( c.getName().equals("CCC")) {
//				System.out.println(c.getAge());
//				break;
//			}
//		}
		
		for(Customer c : map.values()) {
			if( c.getName().equals("CCC")) {
				System.out.println(c.getAge());
				break;
			}
			
		}
		
		//3.map에 있는 사람 중에서 최고 연령과 최소 연령의 사람을 각각 출력
//		System.out.println(Collections.max(map.values()));
//		System.out.println(Collections.min(map.values()));

//		int max = 0;
//		int min = Integer.MIN_VALUE;
//		for( Customer c : map.values() ) {
//			Customer maxC = null;
//			Customer minC = null;
//			
//			if( c.getAge() > maxC.getAge()) {
//				max = maxC.getAge();
//				maxC = c;
//			}
//			if( c.getAge() < minC.getAge()) {
//				min = minC.getAge();
//				minC = c;
//			}
//		}
//		
//		System.out.println(maxC);
//		System.out.println(maxC);
		
		
	}

}
