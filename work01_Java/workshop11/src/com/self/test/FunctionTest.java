package com.self.test;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.self.service.EmployeeService;
import com.self.vo.Employee;


public class FunctionTest {
	public static void main(String[] args) {
		
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "SCOTT", 30000.0));
		employees.add(new Employee(2, "ADAMS", 25000.0));
		employees.add(new Employee(3, "SMITH", 21000.0));
		employees.add(new Employee(4, "KING", 50000.0));
		
		System.out.println("Consumer 사용 예시");
		Consumer<String > c = x-> System.out.printf("%s는 1개의 매개변수를 갖고 반환값은 없어요\n", x.toUpperCase() );
		c.accept("consumer");
		
		
	//1. MVC에 기반한 구조화된 Consumer 사용법
		System.out.println("\n\n=========== 3. 직원들 급여 15% 인상 정보 출력 ==============");
		EmployeeService service = new EmployeeService();
		
		service.raiseSalary(employees, x-> System.out.println(x));
		
		//Consumer<Employee> consumer = x-> System.out.println(x);
		//service.raiseSalary(employees, consumer);
		
		
	// 2. EmployeeService를 사용하지 않고 구조화가 안된 사용법
		// 2-1. forEach 사용
		System.out.println("\n\n=========== 1. 직원들 급여 15% 인상 정보 출력 ==============");
		employees.forEach(x -> {
			x.setSalary(Math.round(x.getSalary() * 1.15));
			System.out.println(x);
		});
		
	
		// 2-2. Consumer 사용
		System.out.println("\n\n=========== 2. 직원들 급여 15% 인상 정보 출력 ==============");
		Consumer<Employee> c3 = x ->{
			x.setSalary(Math.round(x.getSalary() * 1.15));
			System.out.println(x.toString()); // andThen을 쓰면 됨
		};
		for(Employee e : employees )
			c3.accept(e);
		

	}
	
}
