package com.edu.collection3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortTest2 {

	public static void main(String[] args) {
		
		System.out.println("Map 정렬하기");
		System.out.println("====== key 값을 기준으로 정렬 ======");

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(1, 10);
		map.put(11, 500);
		map.put(7, 300);

	/* 오름차순 정렬 */
		// Collections.sort()에 들어갈 수 있는 리스트를 생성
		ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList);
		System.out.println(keyList);
		
		
	/* 내림차순 정렬 */
		Collections.sort(keyList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});
		System.out.println(keyList);
		
		
		
		System.out.println("\n====== value 값을 기준으로 정렬 ======");
		
		ArrayList<Integer> valueList = new ArrayList<Integer>(map.values());
		
	/* 오름차순 정렬 */		
		Collections.sort(valueList);
		System.out.println(valueList);
		
		
	/* 내림차순 정렬 */		
		 Collections.sort(valueList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 -o1;
			}
			 
		 });
		 System.out.println(valueList);
		
	}

}
