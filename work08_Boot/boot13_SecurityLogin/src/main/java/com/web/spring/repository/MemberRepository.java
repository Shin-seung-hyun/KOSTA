package com.web.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	@Query(value = "SELECT m FROM Member m WHERE m.id = :id")
	Member duplicateCheck(String  id); 
	
	//Optional<Member> findByid(Long memberNo); // 기본적으로 상속되어져 있는 함수 
	Member findById(String id); //그러나, id에 해당하는 멤버 검색할 때 오버로딩 기법 적용해보자 : 일종의 QueryMethod이다. Long 이어야 하는데 인자값을 고친 것이다.

	Boolean existsById(String id); // id 에 해당하는 멤버가 있는지 여부 확인 : 오버로딩
}
