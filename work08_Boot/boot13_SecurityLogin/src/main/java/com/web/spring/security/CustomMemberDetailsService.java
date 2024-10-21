package com.web.spring.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.spring.domain.Member;
import com.web.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service // repository를 호출하는 class 임으로 service
@RequiredArgsConstructor // final이 붙은 것을 호출
@Slf4j
public class CustomMemberDetailsService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//DB 연결 .. MemberRepository 호출한다.
		log.info("###### UserDetailsService loadUserByUsername() ...username :: {}", username);// id 값이 출력됨
		
		Member findMember = memberRepository.findById(username);
		
		if(findMember != null) {
			log.info("findMember 찾았다.!!! :: {}", findMember);
			return new CustomMemberDetails(findMember); //UserDetails를 구현한 CustomMemberDetails 를 반환함.
		}
		
		return null;
	}

}
