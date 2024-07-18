package com.edu.collection3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortTest1 {

	public static void main(String[] args) {
		
		System.out.println("List 정렬하기");
		
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(9);
		list.add(33);
		list.add(3);
		
		System.out.println(list);
		
		System.out.println("\n===== 오름차순 정렬 ======");
		Collections.sort(list); // sort는 기본적으로 매개변수가 List
		System.out.println(list);

		Iterator it = list.iterator();
		
		while( it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		System.out.println("\n===== 내림차순 정렬 ======");
		Collections.sort(list, new Comparator<Integer>() { //내림차순 정렬

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 -o1; // 큰수 - 작은 수 = 양수 
			}
		});
		
		//Iterator it = list.iterator();	//iterator는 한번 소진되면 다시 사용할 수 없음.
		
		Iterator it2 = list.iterator();
		
		while( it2.hasNext()) {
			System.out.println(it2.next());
		}
	
	}

}
