package ex03_user;

class Boom extends Exception{

	String msg = "";
	
	public Boom() {
		this("x가 0이면 안되요.. 분모가 될 숫자거든요");
	}
	public Boom(String msg) {
		super(msg);
	}

	
}

class User2{
	//임의의 값 x,y가 함수 호출 시, 인자값으로 들어온다.
	public void calc(int x, int y) throws Boom{ //2. 
		
		
		System.out.println("2. calc(x, y) 함수 호출...");
		if(x == 0) {
			
			//throw new Boom();
			throw new Boom("x가 0이면 안되요.. 분모가 될 숫자거든요"); // 1. JVM이 아닌 사용자가 만듦.
			
		}
			
		// y/x 연산이 진행됨... 
		System.out.println("3. calc 함수 호출 ... x는 0이 아닙니다.");
		
	}
	
}

public class UserExceptionTest2 {

	public static void main(String[] args) { 
		System.out.println("1. User 생성");
		User2 user = new User2(); 	
		
		try {
			user.calc(0,10); //
		} catch (Boom e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("4. 폭탄 처리 성공...");
	}

}
