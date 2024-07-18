package com.edu.collection1;

import java.util.ArrayList;
import java.util.List;

/**
 *  순서를 가지면서 데이터를 핸들링하는 Collection
 *  순서를 가진다는 것은 내부적으로 index로 관리하는 시스템을 말한다.
 *  순서가 있고 중복은 허용된다.
 */
public class ArrayListTest4 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>(); // Constructs an empty list with an initial capacity of ten.
													 // 6명이 되면 20칸인데 6명이 들어 있는 것이다.
		System.out.println(list.size()); // 들어 있는 객체의 수			 
		
		List<String> list2 = new ArrayList<String>(5);// 기본 용량이 10이 아닌 5으로 설정하고 싶을 때 사용
	
		
		list.add("강호동");
		list.add("이수근");
		list.add("강호동");
		list.add("서장훈");
		list.add("김희철");
		
		System.out.println(list);
		
		//1. 3번째 데이터를 삭제
		String str = list.remove(2);
		
		//2. 삭제된 사람을 출력
		System.out.println("\n2. 삭제된 사람은 : " + str);
		
		//3. 맨 처음에 민경훈을 입력
		list.add(0, "민경훈");
		System.out.println("\n3. 민경훈이 추가 됐는지 확인 : " + list);
		
		//4. 민셩훈을 신동으로 수정
		list.set(0, "신동");
		System.out.println("4. 전체 출력 : " + list);
		
		//5. 멤버들 중 "서"로 시작하는 사람을 찾아서 출력
		for(int i=0; i< list.size(); i++) {
			if(list.get(i).startsWith("서")) {
				System.out.println("5. 서 출력 : " + list.get(i));
				break;
			}
		}
		
		
	}

}
