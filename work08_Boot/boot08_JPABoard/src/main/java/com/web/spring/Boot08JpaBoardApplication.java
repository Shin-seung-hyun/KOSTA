package com.web.spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.service.invoker.RequestBodyArgumentResolver;

import com.web.spring.entity.Member;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.MemberRepository;
import com.web.spring.service.MemberService;

@SpringBootApplication
public class Boot08JpaBoardApplication implements CommandLineRunner{

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BoardRepository boardRepository;
	
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		//1. Builder
//		Member m = Member.builder()
//				.id("222")
//				.pwd("1234")
//				.name("김종각")
//				.address("종각")
//				.regDate(LocalDateTime.now())
//				.build();
//		memberRepository.save(m);
//		
		
//		Member findM = memberRepository.duplicateCheck("222");
//		System.out.println("아이디가 222인 사람 :" + findM);
		
//		Member member = Member.builder()
//						.id("park")
//						.pwd("1234")
//						.name("박종각")
//						.address("종각")
//						.regDate(LocalDateTime.now())
//						.build();
//		System.out.println(memberRepository.login(member));
		
		
		// 4. 중복 insert가 되는지 확인해보자
//		Member duplicateMember = Member.builder()
//							.id("111")
//							.pwd("qwer")
//							.name("홍종각2")
//							.build();
//		memberService.signUp(duplicateMember);
		
		
		//5. 모든 게시물 검색 이때 작성자 정보도 함께 검색
//		boardRepository.boardList()
//						.forEach(b->{
//							System.out.println(b);
//							System.out.println(b.getMember());
//						});
		
		
//		boardRepository.findAll()
//						.forEach(b->{
//							System.out.println(b);
//							System.out.println(b.getMember());
//						});
		
		//6. 특정한 작성자가 쓴 게시물 검색
//		boardRepository.getBoard("222")
//						.forEach(b->{
//							System.out.println(b);
//							System.out.println(b.getMember());
//							System.out.println();
//						});
//		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Boot08JpaBoardApplication.class, args);
	}



}
