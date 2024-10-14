package com.web.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Member;
import com.web.spring.exception.MemberAuthenticationException;
import com.web.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

/*
 * final이 붙은 필드를 생성자로 주입하는 롬복 어노테이션
 * 이 방법은 원래 스프링에서 공식적으로 추천하는 라이프 사이클이 같을 때, 주입하는 생성자 주입 방식이다. 
 * 한 번 주입 받은 객체는 프로그램이 끝날 때까지 변하지 않는 특징을 가지고 있음으로
 * 불변성 Immutable로 표시해야 한다.
 * 그래서 MemberRepository 앞에 final 키워드를 붙인다.
 */

@Service
@RequiredArgsConstructor
public class MemberService {

	//이제 setter 주입 쓰지 말자
//	@Autowired
//	MemberRepository memberRepository;
	
	//생성자 주입
	private final MemberRepository memberRepository;
	
	//회원 가입, 중복 체크, 로그인
	@Transactional
	public void signUp(Member member) {
		Member rMember= memberRepository.save(member); //DB에 저장된 Member 반환, id 가 중복되면 에러 발생
		
		System.out.println( "rMember ==> " +  rMember);
	}
	
	@Transactional(readOnly = true)
	public String duplicateCheck(String id) {
		
		Member rMember = memberRepository.duplicateCheck(id);
		System.out.println( "rMember ==> " +  rMember);
		
		if(rMember == null) return "아이디 사용 가능";
		else return "아이디 사용 불가";
		
	}
	
	@Transactional
	public Member singIn(String id, String pwd) {
		
		Member rMember = memberRepository.duplicateCheck(id);
		if(rMember == null) 
			throw new MemberAuthenticationException("id를 다시 확인하세요", "wrong Id~~!!!");
		
		if(!rMember.getPwd().equals(pwd))
			throw new MemberAuthenticationException("pwd를 다시 확인하세요", "wrong pwd~~!!!");
		
		return rMember;
	}
	
	
}
