package com.web.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;

@RestController("api/v1")
@RequestMapping
public class PutControlller {

/*
 * ResponseEntity를 사용하면 좋은 점
 * 1. 결과 데이터와 함께 상태 코드값을 지정할 수 있다.
 * 2. 에러코드와 성공 여부 상태 고드값을 상세하게 지정해서 클라이언트에게 보낼 수 있다.
 * */	
	
	
	@PutMapping("/members")
	public ResponseEntity<?> updateMember(@RequestBody Member pvo){
		//201은 Create
		//200은 Success
		//202은 Update
		// 빌드 패턴
		return ResponseEntity
				.status(202)
				.body(pvo);
		
	}
}
