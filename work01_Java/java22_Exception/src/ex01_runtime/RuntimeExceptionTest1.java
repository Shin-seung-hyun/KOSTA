package ex01_runtime;

/*
	예외 처리를 직접적으로 할 필요가 없이, 바로 소스를 수정하면 된다.
	하지만 이 코드로 직접 예외 처리를 해보자!
*/
public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		
		String[] str = {
			"Hello",
			"No, I mean it",
			"Nice to meet you"
		};
		
//		int i =0;
//		while(i <=3) {
//			System.out.println(str[i]);
//			i++;
//		}

		
		int i =0;
		while(i <=3) {
			try {
				System.out.println(str[i]);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\nNice catch!!");
			}
			
			i++;
		}
		
		System.out.println("The End...");
	}

}
