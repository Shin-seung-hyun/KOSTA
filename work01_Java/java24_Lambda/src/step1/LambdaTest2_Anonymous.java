package step1;

@FunctionalInterface
 interface Workable2{
	 String monthPayment(String ename, double weekSal); 
 }
 
 
class Employee2{ // Workable 을 매개변수로 Hasing
	public void work( Workable2 w) { // 매개변수로 함수형 인터페이스가 들어감
        System.out.println("result =>" +
                			w.monthPayment("SMITH", 2000.0));
	}
	
}
public class LambdaTest2_Anonymous {

	public static void main(String[] args) {
		Employee2 employee = new Employee2();
		
		Workable2 workable = new Workable2() { // 익명 클래스 사용 방식
		    @Override
		    public String monthPayment(String ename, double weekSal) {
		        double salary = weekSal * 4 + 100.0;
		        return ename + "씨의 4주 급여는 " + salary;
		    }
		};
	
		employee.work(workable);
		
	}
	
}
