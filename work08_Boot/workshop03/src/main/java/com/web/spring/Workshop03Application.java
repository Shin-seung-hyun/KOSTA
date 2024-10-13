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
		
		//모든 User 검색
		System.out.println("\n======= 모든 User 검색 ============");
		userRepository.findAll().forEach(u-> System.out.println(u));
		
		//모든 User 정보와 함께 User들이 구입한 Product 정보도 검색
		System.out.println("\n======= 모든 User와 구매한 Product 검색 ============");
		userRepository.findAll().forEach(u->{
			System.out.println(u);
			System.out.println(u.getOrders());
		});
		
		//특정 User 검색
		System.out.println("\n======= 특정 User 검색 ============");
		User user= userRepository.findById(1l).orElseThrow();
		System.out.println(user);
		
		//특정 User 검색과 함께 User가 구입한 Product 정보도 검색
		System.out.println("\n======= 특정 User와 User가 구입한 Product 검색 ============");
		user.getOrders().forEach(p -> System.out.println(p));
		
		
		//1. 모든 상품의 개수를 받아오는 쿼리 메소드 실행
		System.out.println("\n======= 모든 상품의 개수 검색 ============");
		System.out.println(productRepository.countBy());
		System.out.println(productRepository.count());
		
		//2. 조회한 상품 중에 2건만 제한해서 받아오는 쿼리 메소드 실행
		System.out.println("\n======= 상품 중 pro_no로 정렬해서 2개만 출력 ============");
		productRepository.findTop2ByOrderByProNoAsc()
						.forEach(p-> System.out.println(p));

	}

	public static void main(String[] args) {
		SpringApplication.run(Workshop03Application.class, args);
	}



}
