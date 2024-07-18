package com.kosta.test;

import com.kosta.sevice.MovieMgr;
import com.kosta.vo.Movie;

public class MovieTest {

	public static void main(String[] args) {
		
		MovieMgr mgr = MovieMgr.getInstance();
		
		//영화 추가
		System.out.println("1. 영화 추가합니다.");
		mgr.add(new Movie("인사이드아웃1","A감독", 4, "애니", "재미있어요"));
		mgr.add(new Movie("인사이드아웃2","A감독", 3, "애니", "재미있어요"));
		mgr.add(new Movie("탈주1","B감독", 4, "코믹"));
		mgr.add(new Movie("탈주2","B감독", 2, "액션"));
		
		//전체 영화 출력
		System.out.println("\n2. 전체 영화 출력");
		for(Movie m : mgr.serach()) {
			if(m == null) continue;
			System.out.println(m);
		}
		
		//영화 제목 검색
		System.out.println("\n3. 영화 제목 검색");
		for( Movie m : mgr.serach("인사이드아웃1")) {
			if(m == null) break;
			System.out.println(m);
		}
		
		//특정 장르 영화 검색
		System.out.println("\n4. 특정 영화 장르 검색");
		for( Movie m : mgr.serachGenre("코믹")) {
			if(m == null) break;
			System.out.println(m);
		}
		
		//특정 감독 영화 검색
		System.out.println("\n5. 특정 감독 영화 검색");
		for( Movie m : mgr.serachDirector("A감독")) {
			if(m == null) break;
			System.out.println(m);
		}
		
		//영화 제목 삭제
		System.out.println("\n6. 영화 삭제");
		mgr.delete("인사이드아웃2");
		
		System.out.println("\n7. 전체 영화 출력");
		for(Movie m : mgr.serach()) {
			if(m == null) continue;
			System.out.println(m);
		}
		
	}

}
