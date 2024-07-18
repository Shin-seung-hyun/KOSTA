package com.edu.parent;

/*
 * 상속 관계에서 Access Modifier 관계를 정리해보자!
 * public < protected < default > private
 */
public class Parent {
	public String publicField = "publicField";
	protected String protectedField = "protectedField";
	String defaultField = "defaultField";
	private String  privateField= "privateField";
	
	public void access() {
		System.out.println("Acess Modifier Test..");
		System.out.println(publicField);
		System.out.println(protectedField);
		System.out.println(defaultField);
		System.out.println(privateField);
		System.out.println();
	}
	
}
