package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {

	public static void main(String[] args) {

		//1.james, tomas라는 이름으로 고객을 생성
		Customer james = new Customer("James", "인천");
		Customer tomas = new Customer("Tomas", "서울");
		
		//2.james, tomas가 각각의 통장을 개설한다.
			// 조건이 맞지 않으면 생성 불가!
		james.setAccount(new Account(123, "KB", 20000));//시스템을 빠져나오도록
		
		//3.개설한 통장을 반환받아서 통장의 기능을 사용한다.
		//4.james가 1만원, 3만원을 입금하고 2만원을 출금 잔액을 최종적으로 출력한다.

		System.out.println("입금 20000원 >> ");
		james.getAccount().deposit(20000.0);
		
		System.out.println("입금 30000원 >> ");
		james.getAccount().deposit(30000.0);
		
		System.out.println("출금 20000원 >> ");
		james.getAccount().withdraw(20000.0);
		
		System.out.println("최종 잔액은 >> " + james.getAccount().getBalance() + " 원");
		
	}

}