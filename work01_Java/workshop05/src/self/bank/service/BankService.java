package self.bank.service;

import self.bank.vo.Customer;

public class BankService {
	
	private int MAX_CUSTOMERS = 5;
	private int numberOfCustomers;
	
	private Customer[] customers;
	
	public BankService() {
		customers = new Customer[MAX_CUSTOMERS];
	}

	public Customer getCustomer() {
		Customer customer = null;
		
		return customer;
	}

	public void addCustomer(Customer customer) {
		
		customers[numberOfCustomers++] = customer;
	}
	

}
