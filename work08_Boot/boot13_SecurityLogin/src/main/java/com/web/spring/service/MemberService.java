package com.web.spring.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.domain.Member;
import com.web.spring.exception.MemberAuthenticationException;
import com.web.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
	
	//생성자 주입
	private final MemberRepository memberRepository;
	
	// 비밀번호 암호화
	private final PasswordEncoder passwordEncoder;
	
	//회원 가입, 중복 체크, 로그인
	@Transactional
	public void signUp(Member member) {
	
		if(memberRepository.existsById(member.getId()))
			throw new MemberAuthenticationException("중복된 id", "Duplicated ID!");
		
		// 비번 암호화
		String endPwd = passwordEncoder.encode(member.getPwd());
		
		log.info("endPwd ======>{}",endPwd);
		member.setPwd(endPwd);	
		
		//Role 설정
		member.setRole("ROLE_USER"); // 지금은 앞부분에 ROLE_ 를 넣어줘야 한다.
		
		Member savedMember = memberRepository.save(member);
		
		log.info("savedMember ====> {}", savedMember);
	}
	
	@Transactional(readOnly = true)
	public String duplicateCheck(String id) {
		
		Member rMember = memberRepository.duplicateCheck(id);
		log.info("rMember ======> {}", rMember);
		
		if(rMember == null || rMember.equals("")) return "아이디 사용 가능";
		else return "아이디 사용 불가";
		
	}
	
}
