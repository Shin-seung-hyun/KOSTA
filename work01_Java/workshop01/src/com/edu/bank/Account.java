package com.edu.bank;

/**
 * <pre>
 * 
 * 	{@code
 * 		은행 계좌 정보를 저장하는 클래스
 * 		
 * 		이번 Java Document 주석 사용법을 예시로 작성
 * 		이런 작업은 공동작업을 하기 위한 방법^^
 * 		혹은 
 * 		개발자가 자신의 코드를 보완설명하기 위해 사용하는 작업
 * 
 * 	}
 * 
 * 
 * </pre>
 * 
 * 
 * 
 *  은행 계좌 정보를 저장하는 클래스
 *  
 *  @author SHIN SEUNG HYUN
 *  @version Account Project version 1.0.1
 *  @since JDK 17
 */

public class Account {
	
	/**
	 *  계좌 번호
	 *  8자리 숫자로 지정
	 */
	public int accNumber;	//계좌번호
	
	/**
	 * 은행명
	 */
	public String bankName;//은행명
	
	/**
	 * 계좌에 남은 잔액
	 * 혹은
	 * 개설 시 필요 조건으로서의 잔액
	 */
	public double balance;	//잔액
	
	/**
	 * Account 기본 생성자
	 */
	public Account() {}
	
	
	/**
	 * Account 명시적 생성자
	 * 
	 * @param accNumber 계좌 번호
	 * @param bankName 은행명
	 */
	public Account(int accNumber, String bankName) {
		this.accNumber = accNumber;
		this.bankName = bankName;
	}
	
	/**
	 * 
	 * @param balance
	 * 통장을 개설한 이후에 잔액을 다시 입력하는 기능
	 * @deprecated deposit 메소드로 대체 {@link #deposit(double)}
	 */

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * 
	 * @param amt 
	 * 출금 금액을 잔액에서 제외 
	 */

	public void withdraw(double amt) {
		balance -= amt;
	}

	/**
	 * 
	 * @param amt 
	 * 특정 금액을 계좌에 입금
	 * 입금 금액만큼 전체 잔액에 더함
	 */
	public void deposit(double amt) {
		balance += amt; 
	}
	
	
	/**
	 * 
	 * @return 계좌 번호 반환
	 */
	public String getAccountInfo() {
		return "계좌 번호: "+ accNumber + ", 은행명: "+ bankName + ", 계좌 잔액: " + balance;
	}

	
}