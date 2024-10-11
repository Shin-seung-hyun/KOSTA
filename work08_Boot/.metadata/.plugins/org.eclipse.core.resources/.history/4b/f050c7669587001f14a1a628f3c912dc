package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // DB 테이블과 매핑되는 객체.. 자동으로 DB 테이블 명과 필드명이 결정된다.
@Table(name= "custom") // 지금은 @Entity 어노테이션으로 할 필요가 없지만 쓰기, 클래스명과 테이블 명이 다를 때 사용하면 됨
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Custom {

	@Id //유일한 값 PK
	@Column(name ="custom_id") // 안해도 됨
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
	private Integer customId; //custom_id로 자동으로 컬럼명이 잡힌다.
	
	@Column(length = 500)
	private String password;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 200)
	private String email;
	
	@CreationTimestamp
	private LocalDateTime regDate; // 고객이 등록될 때 시간이 자동으로 생성
	
}
