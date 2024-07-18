package com.edu.collection1;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest3 {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
		set.add("강호동");
		set.add("이수근");
		set.add("강호동"); // 중복
		set.add("서장훈");
		set.add("김희철");
				

		System.out.println(" 총 명수 :" + set.size());
		System.out.println("\nCollection은 자체적으로 toString()을 Overriding 했다 ");
		System.out.println(set);
		
		//1. 서장훈이 포함되어 있는지 확인
		System.out.println( "1. 서장훈이 포함됐니? :  " + set.contains("서장훈"));
		
		//2. 현재 Collection이 비어 있는지 확인
		System.out.println("2. Collection이 비어있니? :  " + set.isEmpty());
		
		//3. 이수근 삭제 -> 나머지 사람들 출력
		set.remove("이수근");
		System.out.println("전체 출력 : " + set);
		
		
		//4. set안의 모든 데이터를 삭제
		set.isEmpty();
		
		//5. 정말로 비워졌는지를 확인
		System.out.println( "5. 정말 비어져있니? :"+ set.isEmpty());
	}

}
