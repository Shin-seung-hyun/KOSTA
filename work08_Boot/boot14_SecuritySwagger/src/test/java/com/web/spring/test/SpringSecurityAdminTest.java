package com.web.spring.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import com.web.spring.domain.Member;
import com.web.spring.repository.MemberRepository;

import jakarta.transaction.Transactional;


//JUnit
//admin은 일반 유저와 같이 폼을 통해서 넣지 않고 junit을 통해서 넣었다.
@SpringBootTest
@Transactional
@Commit
public class SpringSecurityAdminTest {
	@Autowired
	private MemberRepository memberRepository;	
	
	@Autowired
	private PasswordEncoder passwordEncoder;	
	
	@Test
	void adminInsert() {
		String encPwd=passwordEncoder.encode("admin");
		memberRepository.save(Member.builder()
								.id("admin")
								.pwd(encPwd)
								.role("ROLE_ADMIN")
								.address("뉴욕")
								.name("제임스")
								.build());
	}
}
