package self.bank.test;

import java.util.Scanner;

import self.bank.Account;
import self.bank.Address;
import self.bank.Customer;
import self.bank.service.BankService;

public class BankTest {		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.고객 등록    2.계좌생성    3.은행업무    4.고객전체명단    5.특정고객정보    6.나가기");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				addCustomer();
				break;
				
			case 2:
				createAccount();
				break;
				
			case 3:
				banking();
				break;
				
			case 4:
				BankService.getInstance().showAll();
				break;
				
			case 5:
				showCustomer();
				break;
				
			case 6:
				sc.close();
				return;
				
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
		
	}
	
	private static void addCustomer() {
		System.out.println("[ 이름  주민등록번호 우편번호 도(행정구역) 지역명 ]순으로 입력하세요.");
		Scanner sc = new Scanner(System.in);
		
		//1. name, ssn, zipcode, region, city
		String name = sc.next();
		int ssn = sc.nextInt();
		int zipCode = sc.nextInt();
		String region = sc.next();
		String city = sc.next();
		
		
		//2. 입력 받은 값으로 customer 생성
		Customer cust = new Customer(name,ssn, new Address(zipCode,region,city));
		
		
		//3. 배열에 생성된 고객을 추가 서비스 기능
		BankService.getInstance().addCustomer(cust);
		System.out.println(name+ " 님 고객 등록 되셨습니다.");
				
	}
	
	private static void createAccount() {
		System.out.print("회원의 주민번호를 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int ssn = sc.nextInt();
		
		int balance = 0;
		
		//1. 입력 받은 ssn에 해당하는 고객이 있다면, 통장 개설을 시작
		if(BankService.getInstance().getCustomer(ssn).getName() != "") { // 고객이 존재한다면
			System.out.println("통장 개설을 위한 잔액을 입력하세요 >>");
			
			balance = sc.nextInt();
			
			BankService.getInstance().getCustomer(ssn).setAccount( new Account(balance));
		
		}
		else { // 고객이 존재하지 않는다면
			
			System.out.println("회원이 존재하지 않습니다. 회원가입부터 시작하세요");
			return;
		}

		
	}

	private static void showCustomer() {//특정회원에 대한 정보를 출력..
		System.out.print("회원의 주민번호를 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int ssn = sc.nextInt();
		
		// 1. 주민번호에 해당하는 고객이 존재한다면 정보를 출력함
		if(BankService.getInstance().getCustomer(ssn).getName() != "") {
			System.out.println(BankService.getInstance().getCustomer(ssn));
		}
		else {
			System.out.println("존재하는 회원이 없어서 종보 출력에 실패했습니다.");
			return;
		}
			
	}
	
	private static void banking() {
		System.out.print("회원의 주민번호를 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int ssn = sc.nextInt();
		
		if(BankService.getInstance().getCustomer(ssn).getName() == "") {
			System.out.println("존재하는 회원이 없습니다.");
			return;
		}
		if(BankService.getInstance().getCustomer(ssn).getAccount() == null) {
			System.out.println("회원님 통장부터 개설하세요");
			return;
		}
		
		while(true) {
			System.out.println("1.입금    2.출금    3.잔액확인    4.나가기");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				deposit(ssn);
				break;
				
			case 2:
				withdraw(ssn);
				break;
			case 3:
				showBalance(ssn);
				break;
			case 4:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	
	private static void deposit(int ssn) {
		System.out.print("입금할 금액을 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();
		
		BankService.getInstance().getCustomer(ssn).getAccount().deposit(amt);
		System.out.println(BankService.getInstance().getCustomer(ssn).getAccount());
	}
	
	private static void withdraw(int ssn) {
		System.out.print("출금할 금액을 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();
		
		BankService.getInstance().getCustomer(ssn).getAccount().withdraw(amt);
		System.out.println(BankService.getInstance().getCustomer(ssn).getAccount());
	}
	
	private static void showBalance(int ssn) {
		//고객의 잔액을 출력한다.
		System.out.println(BankService.getInstance().getCustomer(ssn).getAccount());
	}
	
}
