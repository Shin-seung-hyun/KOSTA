package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	//extends JpaRepository를 통해 save, findById, findByAll, delete, deleteById를 자동적으로 사용할 수 있다.

	//부트 서버를 가동해서 Role 테이블을 생성
}
