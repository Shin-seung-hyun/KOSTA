package ex03_user;


class User{
	//임의의 값 x,y가 함수 호출 시, 인자값으로 들어온다.
	public void calc(int x, int y) throws ArithmeticException{ //3.
		
		
		System.out.println("2. calc(x, y) 함수 호출...");
		if(x == 0) {
			
			//ArithmeticException을 발생시킨다.
			throw new ArithmeticException(); // 2. JVM이 아닌 사용자가 만듦.
			
		}
			
		// y/x 연산이 진행됨... 
		System.out.println("3. calc 함수 호출 ... x는 0이 아닙니다.");
		
	}
	
}

public class UserExceptionTest1 {

	public static void main(String[] args) { 
		System.out.println("1. User 생성");
		User user = new User(); 	
		
		try {
			user.calc(0,10); // 1.

		} catch (ArithmeticException e) { // 4.
			System.out.println("폭탄 처리... x는 0이다.");
		}
		
		System.out.println("4. 폭탄 처리 성공...");
	}

}
