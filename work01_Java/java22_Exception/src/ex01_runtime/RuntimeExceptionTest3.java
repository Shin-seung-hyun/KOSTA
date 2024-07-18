package ex01_runtime;

/*
	try-catch에서 catch는 여려 개를 잡을 수 있다.
	Exception으로 한번에 크게 잡을 수 있다.
*/
public class RuntimeExceptionTest3 {

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
			}
			
			i++;
		}
		
		System.out.println("The End...");
	}

}
