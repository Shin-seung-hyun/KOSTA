package ex01_runtime;

/*
	try : 예외 가능성이 있는 코드
	catch : 예외 발생 시, 잡는 코드
	finally : 예외 발생과 상관 없이 무조건 실행되는 코드
*/
public class RuntimeExceptionTest4 {

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
				
			}catch (Exception e) { 
				System.out.println("\nException catch!!");
				
			}finally {
				//이 부분은 어떨 때 사용할까...?
				System.out.println("이 부분은 무조건 실행됩니다. 예외 발생 여부와 상관 없이...");
			}
			
			
			i++;
		}
		
		System.out.println("The End..."); //예외를 잡아서 정상적으로 종료됨
	}

}
