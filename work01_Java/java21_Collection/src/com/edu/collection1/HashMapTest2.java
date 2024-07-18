package com.edu.collection1;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Map의 자식 : key-value 쌍으로 저장(key는 중복 이 안됨, value는 중복이 가능)
 */
public class HashMapTest2 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap();
		
		map.put("강호동", new Integer(90)); //원래는 이렇게 해야함. Boxing 을 통해 기본 타입을 넣어도 wrapper 로 넣어준다.
		map.put("이수근", 80);
		map.put("서장훈", 95);
		map.put("김희철", 60);
		
		
		/*
		 * 1. 키 값을 뽑아서
		 * 2. 반복문을 통해서 키값에 해당하는 점수를 뽑고
		 * 3. 최종적으로 모든 성적의 합과 평균을 구하라
		 */
		
		System.out.println("========== keySet() =========="); // key를 통해 value를 뽑는 것
		
		int sum = 0;
		for( String key : map.keySet()) {
			
			int score = map.get(key);	 // UnBoxing .. Integer 값을 int로 바꿔준다.
			
			sum += score;
			
			//System.out.println(key + " ==> " + value);
		}
		
		System.out.println("모든 사람들의 성적의 총합은 : " + sum);
		System.out.println("모든 사람들의 성적의 평균은 : " + sum/map.size());
		
		
		
		System.out.println("\n========== values() ==========");	
		int total = 0;
		for( int v : map.values()) {
			total += v;
		}
		System.out.println("모든 사람들의 성적의 총합은 : " + total);
		System.out.println("모든 사람들의 성적의 평균은 : " + total/map.size());
		
		
		System.out.println("\n========== Collections ==========");
		System.out.println("최고 성적은 " + Collections.max(map.values()) );
		System.out.println("최저 성적은 " + Collections.min(map.values()) );
		
		
	}

}
