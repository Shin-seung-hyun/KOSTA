package self.bank.service;

import self.bank.Customer;

/*
 * 1. 일단 객체 생성을 해당 클래스에서 하나는 한다.
 * 		private static 으로 지정해서 객체를 생성한다. 
 * 2. 다른 곳에서는(다른 클래스에서는) 객체 생성이 안되도록 막는다.
 * 		생성자 앞에 private 붙이기
 * 3. 하나 생성한 객체는 여기 저기서 가져다 쓸 수 있도록 static한 기능을 만들어 준다.
 */
public class BankService {
	
	public static final int MAX_CUSTOMERS = 100;
	public Customer[] customers;
	public int numberOfCustomers;	

	//싱글톤 패턴 절차
	//1) 해당 클래스 내 객체 생성
	private static BankService bank = new BankService(); 

	//2) 생성자 앞에 private 붙이기 (public -> private)
	private BankService() {
		System.out.println("Singletone Pattern...");
		customers =new Customer[MAX_CUSTOMERS];
		numberOfCustomers = 0;
	}
	
	//3)
	public static BankService getInstance() {
		return bank;
	}

	//회원가입
	public void addCustomer(Customer cust) {		
		if(numberOfCustomers == MAX_CUSTOMERS) {
			System.out.println("더이상 회원을 받을수 없습니다...");
			return;
		}
		customers[numberOfCustomers++] = cust;
	}
	
	//회원 검색
	public Customer getCustomer(int ssn) {		
		Customer cust = null;
		
		for(int i=0; i<numberOfCustomers; i++) {
			if(customers[i].getSsn()==ssn) cust = customers[i];
		}
		return cust;
	}
	
	public void showAll() {
		if(numberOfCustomers == 0) {
			System.out.println("회원이 아무도 없습니다.");
			return;
		}
		for(int i=0; i<numberOfCustomers; i++) {
			System.out.println(customers[i]);
		}			
	}
}