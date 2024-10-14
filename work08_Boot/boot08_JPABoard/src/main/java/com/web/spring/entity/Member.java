package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 생성자 패턴
 * 	단점 : 순서가 중요함
 * 	Blog blog = new Blog(o,o,o,o);
 * 
 * 빌더 패턴
 * 	장점 : 정확도가 높고 가동력이 좋다.
 * 		  생성자 오버로딩을 대체한다.
 * 	Blog blog = Blog.builer()
 * 					.name("kosat") // setName과 같음
 * 					.id("1234")
 * 					.memo("good")
 * 					.build();
 *  1. 빌더의 각 값들이 생성자 말고 빌더를 통해서 주입 -> 높은 정확ㄱ도
 *  2. 생성자보다 가동력이 좋다.
 *  3. 다양한 인자값으로 객체 생성 시, 생성자 오버로딩 시, 빌드 패턴을 많이하는 추세이다.
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder // 추가!!! 빌더 패턴을 위해
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNo; //pk
	
	@Column(unique = true)
	private String id;
	private String pwd;
	
	@Column(length = 20)
	private String name;
	private String address;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	
	
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", address="
				+ address + ", regDate=" + regDate + "]";
	}
	
}
