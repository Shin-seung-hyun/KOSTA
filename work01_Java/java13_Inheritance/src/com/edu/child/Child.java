package com.edu.child;

import com.edu.parent.Parent;

public class Child extends Parent{
	
	@Override
	public void access() {
		super.access();
		System.out.println("부모에 접근 가능한 field ::" + publicField);
		System.out.println("부모에 접근 가능한 field ::" + protectedField);
		System.out.println();
		
	}
	
	//자식만의 메소드
	public void childAccess() {
		System.out.println(publicField);
		System.out.println(protectedField);
		System.out.println("defaultField, privateField는 접근할 수 없다.");
		System.out.println();
	}

}
