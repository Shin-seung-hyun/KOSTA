package self.bank.vo;

public class Account {

	private int balance;
	
	public Account() {}

	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int mnt) {
		this.balance += mnt;
	}
	
	public void withdraw(int mnt) {
		this.balance -= mnt;
	}
	
	public String toString() {
		
		return "현재 잔액은 :" + balance;
	}
}
