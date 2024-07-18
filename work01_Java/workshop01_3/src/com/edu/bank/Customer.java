package com.edu.bank;


public class Customer {	
	public String name;
	public String address;
	public Account account;

	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public void setAccount(Account account) {			
		this.account = account;			
	}
	
	public Account getAccount() {
		return account;
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCustomerInfo() {
		return "고객명: " + name + ", 주소: " + address;
	}
}