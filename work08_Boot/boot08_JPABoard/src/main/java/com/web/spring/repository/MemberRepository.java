package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.spring.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	//1. 해당 아이디를 받아오는 기능 id가 pk가 아니다. unique라서 JPA에서 제공하는 findById를 사용할 수 없다.
	//JPQL를 사용해서 만들기
	@Query(value = "SELECT m FROM Member m WHERE m.id = :id")
	//@Query(value = "SELECT m FROM Member m WHERE m.id = ?1") // 첫번째 파라미터를 넣음
	//Member duplicateCheck(@Param("id") String  id);
	Member duplicateCheck(String  id); // id와 이름이 같으면 생략 가능
	
	//2. 아이디가 OOO 이고, 패스워드가 OO 인 사람을 검색하는 쿼리
	//JPQL
	@Query(value = "SELECT m FROM Member m WHERE m.id = :#{#member.id} and m.pwd = :#{#member.pwd}")
	Member login(Member member);
	

}
