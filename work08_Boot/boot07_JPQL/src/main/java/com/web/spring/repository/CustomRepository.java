package com.web.spring.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Custom;

public interface CustomRepository extends JpaRepository<Custom, Integer> {

	Optional<List<Custom>> findByName(String name);
	
	Optional<Custom> findByNameAndEmail(String name, String email);
	
	List<Custom> findByNameOrEmail(String name, String email);
	
	List<Custom> findByCustomIdBetween(int startId, int endId);
	
	List<Custom> findByCustomIdLessThan(int customId);
	
	List<Custom> findByRegDateAfter (LocalDateTime yesterday);
	List<Custom> findByRegDateBefore (LocalDateTime yesterday);
	
	//고객의 이름이 null 값인 고객을 검색
	List<Custom> findByNameIsNull();
	List<Custom> findByNameIsNotNull();
	
	//고객 이름이 name인 고객을 검색 (단 와이들 카드 적용 안됨)
	//SELECT * FROM custom WHERE name like ?;
	List<Custom> findByNameLike(String name); // 값에다 %, _ 지정해야 한다.
	
	//SELECT * FROM custom WHERE name like "%종각";
	List<Custom> findByNameEndingWith(String name);
	
	//findByAgeOrderByLastnameDesc
	List<Custom> findByOrderByCustomIdDesc();
	List<Custom> findByOrderByCustomId();
	
	//고객 id가 3보다 큰 아이디를 가지는 고객을 검색 + 아이디를 내림차순으로 정렬
	List<Custom> findByCustomIdGreaterThanOrderByCustomIdDesc(int customId);
	
	//고객 아이디가 1이거나 3이거나 5인 고객을 검색
	List<Custom> findByCustomIdIn(Collection<Integer> ids);
	
	//Not은 null과는 비교하지 않는다. null은 출력되지 않는다.
	List<Custom> findByNameNot(String name);
	
}
