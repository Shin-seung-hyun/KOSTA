package com.self.test;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.self.service.EmployeeService;
import com.self.vo.Employee;


public class FunctionTest {

	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeService();
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1, "SCOTT", 30000.0));
		employees.add(new Employee(2, "ADAMS", 25000.0));
		employees.add(new Employee(3, "SMITH", 21000.0));
		employees.add(new Employee(4, "KING", 50000.0));
		
//		//급여 인상
//		System.out.println("-------- 150% 급여 인상 ----------");
//		Consumer<Employee> c = i-> i.setSalary(1.5);
//		service.raiseSalary(employees, c);
//		Consumer<Employee> c2 = i-> System.out.println(i.toString());
		
		//Consumer 사용 예시
		Consumer<String > con = x-> System.out.printf("%s는 1개의 매개변수를 갖고 반환값은 없어요\n", x.toUpperCase() );
		con.accept("consumer");
		
		
		// 1. 구조화가 안된 forEach 사용법
		System.out.println("\n=========== 1. 직원들 급여 인상 정보 출력 ==============");
		employees.forEach(x -> {
			//x.setSalary(x.getSalary() + x.getSalary() * 0.15);
			x.setSalary(Math.round(x.getSalary() * 1.5));
			System.out.println(x);
		});
		
	
		//2. Consumer 사용법
		System.out.println("\n=========== 2. 직원들 급여 인상 정보 출력 ==============");
		Consumer<Employee> consumer = x ->{
			x.setSalary(Math.round(x.getSalary() * 1.5)); // 직원들의 급여가 15% 인상된 급여로 수정됨
			System.out.println(x.toString());	//단 여기서 출력은 안됨. andThen을 써서 밖에서 출력해야 함
		};
		
		
		//2. MVC에 기반한 구조화된 Consumer 사용법
		System.out.println("\n=========== 3. 직원들 급여 인상 정보 출력 ==============");
		Consumer<Employee> c = x-> System.out.println(x);
		service.raiseSalary(employees, c);
		
		

	}

}
