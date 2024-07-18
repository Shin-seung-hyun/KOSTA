package self.bank.test;

import self.bank.service.BankService;
import self.bank.vo.Account;
import self.bank.vo.Address;
import self.bank.vo.Customer;

public class BankTest {

	public static void main(String[] args) {
		
		
		BankService bankService = new BankService();
		
		Customer c1 = new Customer("이씨", new Address(111, "한국", "서울"));
		Customer c2 = new Customer("이씨", new Account(10_000), new Address(111, "한국", "서울"));
		
		bankService.addCustomer(c1);
		bankService.addCustomer(c2);
		
	}

}
