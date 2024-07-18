package com.edu.oop;

public class Movie {
	
	public String title;
	public String genre;
	int rating;
	
	//기본 생성자
	public Movie() {}
	
	//1. 명시적 생성자
	public Movie(String title, String genre, int rating) {
		
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}
	

	//2. Setter 사용 방법
	public void setMovie(String title, String genre, int rating) {
		
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}
	
	
	//출력
	public String getMovie() {
		return title +", " + genre + ", " + rating;
	}
	
	
	public void palyIt() {
		System.out.println("Playing the movie");
	}

}
