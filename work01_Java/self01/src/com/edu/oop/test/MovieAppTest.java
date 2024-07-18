package com.edu.oop.test;

import com.edu.oop.Movie;

public class MovieAppTest {

	public static void main(String[] args) {

		//1. 생성자 사용 방법
		Movie one= new Movie("Gone with the Stock", "Tragic",-2);
		Movie two= new Movie("Lost in Cubicle Space", "Comedy",5);
		Movie three= new Movie("Byte Club", "Tragic but ultimately uplifting",127);
		
		// 출력
		System.out.println(one.getMovie());
		System.out.println(two.getMovie());
		System.out.println(three.getMovie());
		
		
		//2. Setter 사용 방법
//		Movie one = new Movie();
//		Movie two = new Movie();
//		Movie three = new Movie();
//		
//		one.setMovie("Gone with the Stock", "Tragic",-2);
//		two.setMovie("Lost in Cubicle Space", "Comedy",5);
//		three.setMovie("Byte Club", "Tragic but ultimately uplifting",127);
//		
//		// 출력
//		System.out.println(one.getMovieInfo());
//		System.out.println(two.getMovieInfo());
//		System.out.println(three.getMovieInfo());
		
		
	}

}
