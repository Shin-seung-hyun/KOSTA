package com.edu.bank.test;

import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {

	public static void main(String[] args) {
		
		Customer james = new Customer("james", "서울", makeAccount());
		Customer tomas = new Customer("tomas", "부산", makeAccount());

		//입금
		System.out.println("10_000원 입금");
		james.getAccount().deposit(10_000);
		System.out.println(james.getAccount().getAccountInfo());

		System.out.println("20_000원 입금");
		james.getAccount().deposit(20_000);
		System.out.println(james.getAccount().getAccountInfo());
		
		//출금
		System.out.println("20_000원 출금");
		james.getAccount().deposit(20_000);
		System.out.println(james.getAccount().getAccountInfo());

	}
	
	//계좌 입력 받기
	public static Account makeAccount() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계좌 번호 입력 : ");
		int accNumber = Integer.parseInt(sc.nextLine());
		
		System.out.print("은행명 입력 : ");
		String bankName = sc.nextLine();
		
		
		Account account = new Account(accNumber, bankName); 
		
		System.out.println(account.getAccountInfo());
		System.out.println();
		
		return account;
	}

}