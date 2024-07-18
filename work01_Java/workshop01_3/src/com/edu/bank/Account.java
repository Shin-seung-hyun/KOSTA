package com.edu.bank;

public class Account {

	int accNumber;
	String bankName;
	double balance;
	public Account() {};

	//1.Toss -> 0원이여도 개설 가능
    //   KB -> 10,000원 이상이여야 개설 가능
	public Account(int accNumber, String bankName, double balance) {
		if (!bankName.equals("KB") || (bankName.equals("KB") && balance >=10_000)){
			this.accNumber = accNumber;
			this.bankName = bankName;
			this.balance = balance;
		}
		
		else {
		
			System.out.println("KB 계좌 개설 불가");
			System.exit(0);
		}
	}

	public int getAccNumber() {
		return accNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public double getBalance() {
		return balance;
	}

	//2. deposit() -> 1,000원 이상 입금 가능
	//   1,000원이하 입금이 될 경우 다시 deposit() 실행
	public void deposit(double amt) {
		if (amt < 1000) {
			System.out.println("1,000원 이상 입금해야 합니다.");
			return;
		} else {
			balance += amt;
		}
	}
	
	//3. withdraw() -> 현재 잔액보다 많은 돈을 출금 X
	//   그럴경우, 다시 실행 
	public void withdraw(double amt) {
		if (amt > balance) {
			System.out.println("잔액 부족, 다시 입력해 주세요");
			return;
		} else {
			balance -= amt;
		}	
	}
	
	//계좌 출력
	public String getAccountInfo() {
		return "계좌 번호: "+ accNumber + ", 은행명: "+ bankName + ", 계좌 잔액: " + balance;
	}

}