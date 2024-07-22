package step1;

@FunctionalInterface
 interface Workable{
	 String monthPayment(String ename, double weekSal); // 추상메소드 
 }
 
 
class Employee{ // Workable 을 매개변수로 Hasing
	public void work( Workable w) { // 매개변수로 함수형 인터페이스가 들어감
		String result = w.monthPayment("SMITH", 2000.0);
		System.out.println("result =>" + result);
	}
	
}
public class LambdaTest2 {

	public static void main(String[] args) {
		
		Employee employee = new Employee();
		employee.work( (a,b) -> {
			
			//구현체를 람다로 작성
			double salary =  b * 4 + 100.0;
			return a + "씨의 4주 급여는 " + salary;
		});
		
	}
	
}
