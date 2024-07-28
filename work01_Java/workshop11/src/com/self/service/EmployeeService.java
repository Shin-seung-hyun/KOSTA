package com.self.service;

import java.util.List;
import java.util.function.Consumer;

import com.self.vo.Employee;

public class EmployeeService {
	
	public List<Employee> raiseSalary( List<Employee> emps, 
									   Consumer<Employee> c){
		
		for(Employee e : emps) {
			e.setSalary(Math.round(e.getSalary() * 1.15));
			c.accept(e);
		}
		
		return emps;
	}

}
