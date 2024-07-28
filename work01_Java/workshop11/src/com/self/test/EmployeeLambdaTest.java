package com.self.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.self.service.EmployeeService;
import com.self.vo.Employee;

public class EmployeeLambdaTest {
	
	private static void raiseSalary(List<Employee> list, Consumer<Employee> c) {
		for(Employee e : list) c.accept(e); // 모든 직원의 급여가 15% 인상됨
	}

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1, "SCOTT", 30000.0));
		employees.add(new Employee(2, "ADAMS", 25000.0));
		employees.add(new Employee(3, "SMITH", 21000.0));
		employees.add(new Employee(4, "KING", 50000.0));
		
		
		//MVC 패턴을 생각하지 않고 오직 Lambda 적으로만 만들었을 때,
		System.out.println("\n=========== 1. 직원들 급여 15% 인상 정보 출력 ==============");
		Consumer<Employee> consumer = x->{
			x.setSalary(Math.round(x.getSalary() * 1.15));
		};
		
		//raiseSalary(employees, consumer.andThen(System.out.println(consumer)));
		raiseSalary(employees, consumer.andThen(System.out::println));
	
	}

}
