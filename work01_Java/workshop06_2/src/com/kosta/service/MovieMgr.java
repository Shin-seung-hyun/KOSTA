package com.kosta.service;

import com.kosta.vo.Movie;
public class MovieMgr {
	private Movie[ ] movies = new Movie[10];
	private int index;
	
	//싱글톤...MovieMgr을 mgr이름으로 객체 생성...getInstance로 생성한 객체를 받아온다.
	private static MovieMgr mgr = new MovieMgr();
	private MovieMgr() {}
	public static MovieMgr getInstance() {
		return mgr;
	}
	
	public void add(Movie m) {
		movies[index++] = m;
	}
	
	//serachAll이지만 오버로딩을 위해 seach로 선언
	public Movie[] search() {
		Movie[] nMovies = new Movie[index];
		for(int i=0; i<index; i++) {
			nMovies[i]=movies[i];
		}
		return nMovies;
	}
	
	public Movie[] search(String title) {
		int temp = 0;
		Movie[] nMovies = new Movie[index];	// 10칸이 아닌 Movie에 들어 있는 값만큼만 return한다.
		
		for(Movie m : movies) {
			if(m==null) break;
			if(m.getTitle().contains(title)) {	// 인사이드 아웃, 인사이드 모두 가능함으로 특정한 단어가 포함돼 있으면으로 조건문
				nMovies[temp++]=m;
			}
		}
		
		//null값을 추리기 위해 다시 for문을 동작시킴
		Movie[] realmovies = new Movie[temp];
		for(int i=0; i<temp; i++)
			realmovies[i] = nMovies[i];
		
		return realmovies;
	}

	public Movie[] searchDirector(String name) {
		int size = 0;
		for(int i=0; i<index ; i++) {
			if(movies[i].getDirector().contains(name)) size++;
		}
		
		Movie[] nMovies = new Movie[size];
		for(int i=0; i<index; i++) {
			if(movies[i].getDirector().contains(name)){
				nMovies[--size] = movies[i];	//뒤에서 앞으로 입력된다.
			}
		}
		
		return nMovies;
	}

	public Movie[] searchGenre(String genre) {
		int temp = 0;
		for(Movie m : movies) {
			if(m==null)
				break;
			if(m.getGenre().equals(genre)) {
				temp ++;
			}
		}
		Movie[] rearMovies = new Movie[temp];
		for(int i = 0; i<temp;) {
			for(Movie m : movies) {
				if(m==null)
					return rearMovies;
				if(m.getGenre().equals(genre)) 
					rearMovies[i++] = m;
			}
		}
		return rearMovies;
	}

	public void delete(String title) {
		
		for(int i=0; i<index; i++) {
			if(movies[i].getTitle().contains(title)) {
				
				for(int j=i; j<index; j++) {
					movies[j] = movies[j+1];
				}
				movies[index] =null;
				index--;
				
				break;
			}
			
		}
		
			
	}
	
	public int getSize() {
		return index;
	}
}







