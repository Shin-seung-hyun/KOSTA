package com.edu.bank;

public class Customer {
	
	public String name;	//이름
	public String address;	//주소
	
	Account account;
	
	public Customer() {}

	public Customer(String name, String address, Account account) {
		this.name = name;
		this.address = address;
		this.account = account;
	}
	
	public String getCustomerInfo() {
		return 	"고객 이름 : "+ name+ " 주소 : "+ address;
	
	}
	
	public Account getAccount() {
		return account;
	}


}