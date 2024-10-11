package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.User;
import com.web.spring.repository.ProductRepository;
import com.web.spring.repository.UserRepository;

@SpringBootApplication
public class Workshop03Application implements CommandLineRunner{
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
//		//모든 User 검색
//		userRepository.findAll().forEach(u-> System.out.println(u));
//		
//		//모든 User 정보와 함께 User들이 구입한 Product 정보도 검색
//		userRepository.findAll().forEach(u->{
//			System.out.println(u);
//			System.out.println(u.getOrders());
//		});
//		
//		//특정 User 검색
//		User user= userRepository.findById(1l).orElseThrow();
//		System.out.println(user);
//		
//		//특정 User 검색과 함께 User가 구입한 Product 정보도 검색
//		user.getOrders().forEach(p -> System.out.println(p));

	}

	public static void main(String[] args) {
		SpringApplication.run(Workshop03Application.class, args);
	}



}
