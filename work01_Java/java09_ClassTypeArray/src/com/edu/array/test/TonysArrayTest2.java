package com.edu.array.test;


class Contact2{
	String name;
	
	public Contact2(String name) {
		this.name = name;
	}

	public void printName() {
		System.out.println(name+ "... print!");
	}
	
}



public class TonysArrayTest2 {

	public static void main(String[] args) {

		Contact2 contactRef = null;
		int x = 0;
		while(x<10) {
			
			contactRef = new Contact2("PersonName" + contactRef);
			System.out.println( x + " : Contact2 Reference => " + contactRef);
			x++;
		}

		System.out.println();
		contactRef.printName();
		
		
	}

}
