package self.bank.vo;

public class Customer {
	private String name;
	private int ssn;
	
	private Address address;
	private Account account;
	
	public Customer() {}
	
	public Customer(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	public Customer(String name, Account account, Address address) {
		this.name = name;
		this.account = account;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String toString() {
		
		return name + ", " + ssn;
	}
	

}
