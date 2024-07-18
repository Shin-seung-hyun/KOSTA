package self.bank.test;

import self.bank.service.BankService;

public class SingletoneTest {

	public static void main(String[] args) {
		
		//private이기에 접근이 안됨.
		//BankService s1 = new BankService();
		
		//객체 생성 안 하고, static 에 올라간것을 가져다 쓴다
			//모두 주소값이 같음.
		BankService s1 = BankService.getInstance();
		BankService s2 = BankService.getInstance();
		BankService s3 = BankService.getInstance();

		System.out.println();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println("===========================");
		//1.참조 변수 뒤에는 toString이 생략되어 있는 것이다.
		//2.java에서의 주소값은 String으로 저장되어 있다.
		//3. s3 내에 toString()이 안보여도 있는 것이다.
		// 자바는 메모리 관리는 개발자가 안하고, Automatic하게 하기에 안보이는 거?
		// toString()은 주소값을 출력해서 우리는 getDetail() 안하고 Override하자!
		System.out.println(s3.toString());
	}

}
