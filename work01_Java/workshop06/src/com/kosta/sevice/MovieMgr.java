package com.kosta.sevice;

import com.kosta.vo.Movie;

public class MovieMgr {

	private Movie[] movies;
	private int index;
	
	private static final MovieMgr mgr = new MovieMgr(10);
	
	private MovieMgr() {}
	
	private MovieMgr(int size) {
		movies = new Movie[size];
	}
	
	public static MovieMgr getInstance() {
		return mgr;
	}
	
	public void add(Movie m) {
		
		if(index >= movies.length) {
			System.out.println("영화 추가가 불가능합니다.");
		}
		movies[index++] = m;
		
	}
	
	//전체 영화 검색
	public Movie[] serach() {
		
		return movies;
	}
	
	//영화 제목 검색
	public Movie[] serach(String title) {
		
		int idx=0;
		Movie[] tmp = new Movie[movies.length];
		
		for(Movie m : movies) {
			if(m == null) break;
			if(m.getTitle().equals(title))
				tmp[idx++] = m;
		}
		
		return tmp;
	}
	
	
	//특정 장르 영화 검색
	public Movie[] serachGenre(String genre ) {
		
		int idx=0;
		Movie[] tmp = new Movie[movies.length];
		
		for(Movie m : movies) {
			if(m == null) continue;
			if(m.getGenre().equals(genre))
				tmp[idx++] = m;
		}
		
		return tmp;
	}
	
	//특정 감독 영화 검색
	public Movie[] serachDirector(String director ) {
		
		int idx=0;
		Movie[] tmp = new Movie[movies.length];
		
		for(Movie m : movies) {
			if(m == null) continue;
			if(m.getDirector().equals(director))
				tmp[idx++] = m;
		}
		
		return tmp;
	}
	
	public void delete(String title) {
		
		for(int i=0; i<movies.length; i++) {
			if(movies[i] == null) break;
			if(movies[i].getTitle().equals(title)){
				
				for(int j = i; j<movies.length-1; j++) {
					
					if(movies[j] != null) {
						movies[j] = movies[j+1];
					}
					else {
						break;
					}
				
				}	
			}
			
		}
	}

	//영화 배열 사이즈 출력
	public int getSize() {
		
		return  movies.length;
	}
	

}
