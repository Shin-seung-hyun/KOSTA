package com.edu.collection3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import com.edu.vo.Person;

public class SortTest3 {

	public static void main(String[] args) {
		
		//1.
		List<String> names = new ArrayList<String>();
		names.add("Lucy");
		names.add("Adams");
		names.add("Juliet");
		names.add("Bob");
		
		System.out.println("정렬전 ==> " + names);
		Collections.sort(names);
		System.out.println("정렬후 ==> " + names);
		
		//2.
		List<Person> people = new ArrayList<Person>();
		people.add(new Person(11, "Lucy"));
		people.add(new Person(22, "Adams"));
		people.add(new Person(7, "Juliet"));
		people.add(new Person(55, "Bob"));
		
		System.out.println("정렬전 ==> " + people);
		
		//Compare로 정렬
//		Collections.sort(people, new Comparator<Person>() { //Person 클래스는 Comparable 인터페이스를 상속 받고 있지 않기 때문이다.
//
//			@Override
//			public int compare(Person p1, Person p2) {
//				return p1.getAge() - p2.getAge();
//			}
//		});
		
		//Person 클래스의 name순으로 정렬 .. Comparable
		Collections.sort(people);
		System.out.println("정렬후 ==> " + people);
		
	}

}


//Comparable 상속
 class Person implements Comparable<Person>{
		private int age;
		private String name;
		
		public Person() {}
		
		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}

		@Override
		public int compareTo(Person p) { // 이름순으로 정렬
			
			//return this.name.compareTo(p.getName()); // 오름차순 정렬
			return p.getName().compareTo(this.name);
		}
 }
