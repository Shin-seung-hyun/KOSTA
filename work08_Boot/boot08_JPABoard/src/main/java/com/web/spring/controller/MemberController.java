package com.web.spring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.web.spring.entity.Member;
import com.web.spring.service.MemberService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	@PostMapping("/members")
	public String signUp(@RequestBody Member member) {
		
		memberService.signUp(member);
		
		return "OK";
	}
	
	@GetMapping("/members/{id}")
	public String duduplicateCheck(@PathVariable String id) {
		System.out.println("id ==> " + id);
		
		return memberService.duplicateCheck(id);
	}
	
	@PostMapping("/members/login")
	public Member singIn(@RequestBody Member member) {
		
		Member rMember = memberService.singIn(member.getId(), member.getPwd());
		return rMember; // 클라이언트에게 데이터가 날라간다. Json 형태로 변환해서 날라간다.
	}
	
}
