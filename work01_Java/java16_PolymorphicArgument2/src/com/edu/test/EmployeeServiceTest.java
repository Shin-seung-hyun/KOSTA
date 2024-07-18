package com.edu.test;

import java.util.Arrays;

import com.edu.service.EmployeeServiceImpl;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

public class EmployeeServiceTest {
	public static void main(String[] args) {	
		Manager m = new Manager(1234, "AAA", "천호동", 320, "개발부");
		Engineer eg = new Engineer(5566, "BBB", "판교", 100, "JAVA", 500);
		Engineer eg1 = new Engineer(7090, "CCC", "판교", 400, "NodeJS", 500);
		Secretary s = new Secretary(7369,"DDD", "상일동", 450, "AAA");
		
		//container : 모든 직원 정보를 주입함 Has a relation
		Employee[ ] emps = {m, eg, eg1, s};		

		EmployeeServiceImpl service= EmployeeServiceImpl.getInstance();
		
		System.out.println("\n*****1. getAllEmployee calling *******");
				
		//Polymorphic Argument		
		//온전한 서비스의 단위임으로 매개변수를 모두 넣음		
		Employee[ ] ea = service.getAllEmployee(emps); 
		for(Employee e : ea)System.out.println(e);
		 
			
		System.out.println("\n*****2.findEmployee calling *******");
		System.out.println(service.findEmployee(emps, 5566));
		
				
		System.out.println("\n*****3. findEmployee calling *******");
		//Method Overloading
		System.out.println(Arrays.toString(service.findEmployee(emps, "판교")));
		
	
		System.out.println("\n*****4. getAnnualSalary calling *******");
		System.out.println("Anuual Salary :: "+service.getAnnualSalary(ea[0]));
		System.out.println("Anuual Salary :: "+service.getAnnualSalary(ea[2]));
		
		
		System.out.println("\n*****5. getTotalCost calling *******");
		System.out.println("[모든 고용인들의 연간 총 인건비는 ::]" +service.getTotalCost(ea));

	}
}






















