package com.edu.statictest;


class Member{
	int ssn = 1234;
	static String name = "길동";
	static int age = 19;
	
	public static void memberInfo() {
		System.out.println("우/유/빛/깔/ " + name ); // (O)
		//System.out.println("우/유/빛/깔/ " + name + ", " + ssn); //(X)
	}
	
}


public class StaticExamTest1 {

	public static void main(String[] args) {
		
//		System.out.println(Member.name);
//		Member.memberInfo();
		
		Member m = new Member();
		System.out.println(m.name); //class area의 값을 참조함.
		m.memberInfo();

	}

}
