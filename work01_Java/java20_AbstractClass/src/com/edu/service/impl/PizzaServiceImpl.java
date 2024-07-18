package com.edu.service.impl;

import com.edu.parent.Pizza;
import com.edu.service.PizzaService;

public class PizzaServiceImpl implements PizzaService{
	
	
	//싱글톤 패턴
	//1. Private static 으로 만든다.
	private static PizzaServiceImpl service = new PizzaServiceImpl();

	//2. 생성자에 private 붙이기
	private PizzaServiceImpl() {}
	
	//3. 외부에서 호출하게
	public static PizzaServiceImpl getInstance() {
		return service;
	}
	
	
	@Override
	public void allMakePizza(Pizza[] pizzas) {
		
		for(Pizza p : pizzas) {
			System.out.println(p);
			
			p.sequencePizza(); //피자 하나 만듦
			System.out.println("=================");
		}
	}
	

}
