package com.edu.service;

import com.edu.vo.Customer;
import com.edu.vo.Product;

/*
 * 아울렛에서 상품을 구매하는 고객의 기능을 정의하고 있는 클래스
 * service 클래스는 기능만으로 구성된 Class
 * Vo,Test,service 클래스를 작성하게 되면 구조적인 Application 을 java SE기반으로 만들 수 있다.
 */

public class OutletService {
	
//메소드 정의만 하기!	
	
	//1) 특정 고객이 구입한 상품을 반환하는 기능
	public Product[] getAllProduct(Customer vo) {
		
		return vo.getProducts();
	}
	
	//2) 특정 고객이 구입한 상품의 maker 만을 반환하는 기능
	public String[] getAllProductMaker(Customer vo) {
		 
		String[] temp = new String[vo.getProducts().length];
		
		int idx= 0;
		for(Product p : vo.getProducts()) {
			temp[idx++] = p.getMaker();
		}
		
		return temp;
	}
	
	//3) outlet 안에 있는 고객 중에서 특정한 고객을 검색하는 기능
	public Customer findCustomer(Customer[] customers, int ssn) {
		
		Customer customer = null;
		
		for(Customer c : customers) {
			
			if( c.getSsn() == ssn) customer = c;
		}
		
		return customer;
	}
	
	//*메소드 오버로드
	//4) outlet 안에 있는 고객중에서 동일한 주소를 가지고 고객들을 반환
	public Customer[] findCustomer(Customer[] customers, String address) {
		
		// 같은 주소를 같는 고객 사이즈를 모름
			//1. 최대 사이즈로 설정
			//2. 
		Customer[] temp = new Customer[customers.length]; 
		int idx = 0;
		for(Customer c : customers) {
			if(c.getAddress().equals(address)) 
				temp[idx++] = c;
		}
		
		return temp;
	}
	
	//5) 특정 고객이 구입한 물건 중에서 최고가에 해당하는 물건의 가격을 리턴하는 기능
	public int maxPrice(Customer vo) {
		
		int maxPrice = 0;
		for(Product p : vo.getProducts()) {
			if(p.getPrice()> maxPrice) maxPrice = p.getPrice();
		}
		
		return maxPrice;
	}
	
	//6) 모든 고객이 구입한 물건 중 특정 가격 이상이 되는 제품들을 반환하는 기능
	public Product[] getMorePriceProduct(Customer[] customers, int price) {
		
		int size = 0;
		for(Customer c : customers) {
			if(c.getProducts() !=null) 
				size += c.getProducts().length;
		}
		
		Product[] temp = new Product[size];
		int idx = 0;
		//상품을 구매하지 않은 제니를 위한 구문
		for(Customer c : customers) {
			if(c.getProducts() == null) continue;
			for(Product p : c.getProducts()) {
				if( p.getPrice() >= price)
					temp[idx++] = p;
			}
		}
		
		return temp;
	}
}
