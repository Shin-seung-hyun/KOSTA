package ex01_runtime;

/*
	try-catch에서 catch는 여려 개를 잡을 수 있다.
	1. 단, 하나의 catch문만 돌아간다.
	2. 예외를 잡을 때는 작은 예외에서 큰 예외 순으로 잡는다. 아님 에러 발생 
*/
public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		
		String[] str = {
			"Hello",
			"No, I mean it",
			"Nice to meet you"
		};
		

		int i =0;
		while(i <=3) {
			try {
				System.out.println(str[i]);
				
			}catch (NullPointerException e) { //객체 생성하지 않고 멤버에 접근했을 때 발생하는 에러
				System.out.println("\nNullPointerException catch!!");
				
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\nNice catch!!");
				
			}catch (ArithmeticException e) {	//분모를 0으로 했을 때 발생하는 에러
				System.out.println("\nArithmeticException catch!!");
			
			}catch (Exception e) { 
				System.out.println("\nNullPointerException catch!!");
				
			}
			
			
			
			i++;
		}
		
		System.out.println("The End...");
	}

}
