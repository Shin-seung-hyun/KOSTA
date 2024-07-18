package com.edu.vo;

/*
 * 상품을 구입하는 고객에 대한 정보를 담고 있는 vo 클래스
 * Web 스펙에 가서는 Model에 해당되는 클래스로 승격된다.
 */
public class Customer {
	private int ssn; //주민등록 번호 social security number
	private String name;
	private String address;
	
	private Product[] products;
	
	public Customer() {}

	public Customer(int ssn, String name, String address) {
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public int getSsn() {return ssn;}

	public String getName() {return name;}

	public String getAddress() {return address;}

	public void changeAddress(String address) {this.address = address;}
	
	//Has a relation
	public Product[] getProducts() {
		return products;
	}

	public void buyProducts(Product[] products) {
		this.products = products;
	}
	
	
	public String getCustomerInfo() {
		return name + ", " + address;
	}
	
	

}
