package com.web.spring.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name= "user") 
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString
public class User {

	@Id 
	@Column(name ="user_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long userId; 
	
	@Column(length = 500)
	private String password;
	
	@Column(length = 50)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	//@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name ="orders",
				joinColumns = @JoinColumn(name="user_id"), //user 외래키
				inverseJoinColumns = @JoinColumn(name="pro_no")) // product 외래키
	List<Product> orders = new ArrayList<>();
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + "]";
	}
	
}
