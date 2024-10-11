package com.web.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
