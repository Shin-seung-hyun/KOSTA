package com.web.spring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.web.spring.domain.Member;
import com.web.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

	private final MemberService memberService;
	
	@PostMapping("/members")
	public ResponseEntity<?> signUp(@RequestBody Member member) {
		
		log.info("member signUp ==> {}", member);
	
		memberService.signUp(member);
		
		return ResponseEntity.status(201)
							.body("Register OK~~~~");
	}
	
	@GetMapping("/members/{id}")
	public String duduplicateCheck(@PathVariable String id) {
		log.info("duduplicateCheck id ==> {}", id);
		
		return memberService.duplicateCheck(id);
	}
	
}
