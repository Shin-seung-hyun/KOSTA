package com.edu.test;

import com.edu.child.Child;
import com.edu.parent.Parent;

public class AccessModifierTest {

	public static void main(String[] args) {

		Parent parent = new Parent();
		Child child = new Child();
		
		
		System.out.println("====== Parent의 함수 호출 입니다. ======");
		parent.access(); //부모의 access 호출
		
		
		System.out.println("======= Child의 함수 호출입니다. =======");
		child.childAccess();//자식의 access 호출
		
		System.out.println("== Overriding 된 메소드 ==");
		child.access();
		

	}

}
