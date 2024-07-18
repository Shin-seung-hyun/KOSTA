package com.edu.loop.test;

public class BasicLoopingTest1 {

	public static void main(String[] args) {
		
		System.out.println("========= for ==========");
		
		for(int i =0; i<10; i++) {
			System.out.println("Hello for Looping " + i);
		}

		
		System.out.println();
		System.out.println("========= whlie ==========");
		
		int i= 10;
		while(i > 0) {
			System.out.println("Hello for Looping " + i);
			i--;
		}
		
		System.out.println();
		System.out.println("========= do whlie ==========");
		
		int j = 10;
		do{
			System.out.println("Hello for Looping " + j);
			j++;
		} while(j<10);
		
		
	}

}
