package com.web.spring;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Board;
import com.web.spring.entity.Custom;
import com.web.spring.entity.Role;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.CustomRepository;
import com.web.spring.repository.RoleRepository;


@SpringBootApplication
public class Boot07JpqlApplication implements CommandLineRunner{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	CustomRepository customRepository;
	
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
	//1. 모든 게시글 검색 (N+1문제로 성능상 문제가 있다.)
//		boardRepository.findAll()
//							.forEach(b->{
//								System.out.println(b);
//								System.out.println(b.getCustom());
//							});
		 
	//2. JPQL
//		boardRepository.getBoards()
//						.forEach(b->{
//							System.out.println(b);
//							System.out.println(b.getCustom());
//						});
//		
//		Long boardCount = boardRepository.getBoardCount();
//		System.out.println("전체 게시글 수 :" +  boardCount + " 개");
		
		
	//3. admin 권하는 가지는 사람이 작성한 게시글을 다 검색하는 쿼리 [쿼리 3개 발생]
//		Role role= roleRepository.findById(2).get(); // role은 admin 권한을 가지고 있다. [쿼리1 발생]
//		System.out.println( "Role ==> "+ role);
//		
//		Custom c = new Custom();
//		c.setName("한강");
//		c.setEmail("han@namver.com");
//		c.setPassword("123");
//		c.setRegDate(LocalDateTime.now());
//		c.setRoles(Set.of(role)); // 사용자의 권한을 set으로 주입
//		
//		customRepository.save(c); // 사용자 생성 [쿼리2 insert custom, 쿼리3 insert custom_role 발생] 
		
	//4. admin 권한을 가지는 11번 사용자가 게시글을 작성하자
//		Custom c= customRepository.findById(11).get();
//		Board b = new Board();
//		b.setCustom(c);
//		b.setTitle("관리자 권한 작성");
//		b.setContent("관리자 권한을 가지고 있어요");
//		b.setRegDate(LocalDateTime.now());
//		
//		boardRepository.save(b); // 관리자 권한을 가지는 사람이 게시글을 작성
		
		
//		//5.
//		boardRepository.getBoards("ROLE_ADMIN")
//						.forEach(b->{
//							System.out.println(b);
//							System.out.println(b.getCustom());
//						});
		
		
//		boardRepository.getBoardsNative()
//						.forEach(b->{
//							System.out.println(b);
//							System.out.println(b.getContent());
//							System.out.println(b.getTitle());
//							System.out.println(b.getCustom());
//						});
		
		boardRepository.getBoardsNative2()
						.forEach(b->{
							System.out.println(b.getClass().getName()); // Proxy
							System.out.println(b.getContent()); // null
							System.out.println(b.getTitle());
							System.out.println(b.getCustomId());
							System.out.println(b.getBoardId());
							System.out.println(b.getName());
							System.out.println("====================================");
						});
	}
	

	public static void main(String[] args) {
		SpringApplication.run(Boot07JpqlApplication.class, args);
	}
}
