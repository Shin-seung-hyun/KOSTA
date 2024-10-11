package com.web.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {

	@Id //유일한 값 PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
	private Integer id;
	
	@Column(length = 500)
	private String password;
	
	@Column(length = 50)
	private String name;	

}


