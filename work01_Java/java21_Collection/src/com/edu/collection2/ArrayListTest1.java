package com.edu.collection2;

import java.util.ArrayList;

import com.edu.vo.Person;

public class ArrayListTest1 {

	public static void main(String[] args) {
		
		ArrayList<Person> list = new ArrayList<>();
			//capacity is the total number of cells.
			//size is the number of cells that have data in them.
		
		//add
		list.add( new Person(11, "AA"));	//기본적으로 10칸이 만들어진다. size와는 다르다.
		list.add( new Person(22, "BB"));
		list.add( new Person(33, "CC"));
		list.add( new Person(44, "DD"));
		list.add( new Person(55, "EE"));
		
		System.out.println(list);	// 원래는 list container 의 주소값이 출력된다. 그러나 이제는 @Override 해서 안에 있는 객체값이 나온다.
		
		System.out.println(list.size());
		list.trimToSize();	// 10칸 중 안 쓰는 칸은 줄임 size와 capacity가 같아진다.
		
		
		//리스트에 있는 사람 중에서 2번째 사람의 정보를 출력
		Person secondPerson = (Person) list.get(0);

		
		//list의 사람들 평균 나이
		int sum =0;
		for(Person person : list) {
			sum+= person.getAge();
		}
		System.out.println(sum/list.size());
		
	}

}
