package com.edu.workshop03.bank;

public class Customer {	
	private String name;
	private String address;
	private Account account;

	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public void openAccount(Account account) {			
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