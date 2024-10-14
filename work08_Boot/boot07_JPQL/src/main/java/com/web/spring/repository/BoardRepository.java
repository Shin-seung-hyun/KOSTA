package com.web.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.spring.entity.Board;
import com.web.spring.entity.BoardIF;

public interface BoardRepository extends JpaRepository<Board, Long>{

	//자동적으로 findALl() 모든 게시글 받아오기
	
	/*
	 * JPQL을 사용해보자
	 * JPQL은 SQL과 비슷하지만 SQL이 아니다. 객체지향 언어이다.
	 * JPQL에서 from 절 뒤에는 테이블 명이 아니라 엔터티 이름(class 명이라서 반드시 대문자로 시작)이 나온다.
	 * 반드시 alias를 준다.
	*/
	
	//Board 엔터티는 board 테이블과 매핑된 객체이기 때문에 결과적으로 board 테이블에 있는 모든 것을 조회하는 쿼리이다.
	//@Query(value = "SELECT b FROM Board b") // 1. JOIN을 사용해야 한번에 연결된 정보를 함께 가져온다. (N+1문제 존재)
	//@Query(value = "SELECT b FROM Board b JOIN b.custom") // 2. JOIN 사용 (안됨)
	@Query(value = "SELECT b FROM Board b JOIN FETCH b.custom") //3. 조인하면서 연관된 정보를 바로 받아오려면 fetch를 바로 적용해야 한다.(Eager, Lazy 상관 없이 N+1문제 해결!!)

	//@Query(value = "SELECT b FROM Board b JOIN Custom c ON b.custom.customId= c.customId") //4. [주의] 일반적인 쿼리문은 성능저하를 막을 수 없다.
	//@Query(value = "SELECT b FROM Board b JOIN FETCH Custom c ON b.custom.customId= c.customId") //4. [주의] FETCH 넣어도 일반적인 쿼리문은 성능저하를 막을 수 없다.
	List<Board> getBoards();
	
	
	//전체 게시글 갯수를 반환하는 쿼리
	@Query(value ="SELECT COUNT(b) FROM Board b ") //COUNT(boardId)도 됨 COUNT(board_id)는 안 됨
	Long getBoardCount();
	
	
	// 관리자 권한을 가지는 사람이 작성한 게시글 보기
	/*
		select * 
		from board b, custom c, custom_role cr , role r
		where b.custom_id = c.custom_id
			and c.custom_id = cr.custom_id
		    and cr.role_id = r.role_id
		    and r.name = "ROLE_ADMIN";
		    
		실제 SQL 쿼리문은 테이블 -1 개로 3개가 나오지만,
		JPQL에서는 엔터티로 접근하기 때문에 join이 2번만 나온다. (b.custom/ custom.roles)    
	*/
	
	//@Query(value = "select b from Board b join b.custom c join c.roles r where r.name = :roleName") // [N+1 문제 발생] join은 완벽하지만 Board 안의 Custom은 안 가져옴 나중에 select로 가져옴 
	//@Query(value = "select b from Board b join fetch b.custom c join c.roles r where r.name = :roleName") // [fetch join으로 N+1 문제 해결] fetch는 한번만 작성하면 됨
	@Query(value = "select b,c  from Board b join b.custom c join c.roles r where r.name = :roleName") // [sql projection 으로 N+1 문제 해결]
	List<Board> getBoards(@Param("roleName") String roleName);
	
	
	/*
		Native Query
		DB로 바로 접근한다.
		밴더 종속적이다. (Oracle, MySQL, MSServer)
		복잡한 쿼리라서 JPA로 나타내기 힘든 경우 해법이 될 수 있다.
	*/
	//어떤 사람이 어떤 게시글을 작성했는지 다 볼 수 있는 기능
//	@Query(value = "SELECT b.board_id, b.title, b.content, b.count, b.regDate, b.custom_id, c.name"
//				+ " from board b, custom c "
//				+ " where b.custom_id = c.custom_id", nativeQuery = true)
	@Query(value = "SELECT b,c "
			+ " from board b, custom c "
			+ " where b.custom_id = c.custom_id", nativeQuery = true)
	List<Board> getBoardsNative();
	
	
	//Native Query에서 내가 원하는 컬럼만 Projection 하고 싶다면 .. Board 못 씀
	// select 절에 나오는 Projection을 받아오는 vo를 별도로 작성해야 한다... 인터페이스로 작성
	@Query(value = "SELECT b.board_id, b.title, b.custom_id, c.name"
					+ " from board b, custom c "
					+ " where b.custom_id = c.custom_id", nativeQuery = true)
	List<BoardIF> getBoardsNative2();
	
}
