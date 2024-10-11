package com.web.spring.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name= "user") 
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

	@Id 
	@Column(name ="user_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long userId; 
	
	@Column(length = 500)
	private String password;
	
	@Column(length = 50)
	private String name;

	@OneToMany
	private List<Order> orders;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + "]";
	}
	
}
