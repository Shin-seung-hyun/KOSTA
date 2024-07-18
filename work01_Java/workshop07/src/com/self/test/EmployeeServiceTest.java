package com.self.test;

import com.self.service.EmployeeService;
import com.self.util.MyDate;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;
import com.self.vo.Secretary;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		
		EmployeeService eService = EmployeeService.getInstance();
	
		System.out.println("============ 1. addEmployee ============ ");
		eService.addEmployee(new Manager("James", new MyDate(1999, 1, 1), 30000.0, "기획팀", 111));
		eService.addEmployee(new Manager("Alice", new MyDate(1999, 3, 1), 30000.0 , "기획팀", 222));
		eService.addEmployee(new Engineer("Tomas", new MyDate(1997, 3, 12), 45000.0,"Java", 100));
		eService.addEmployee(new Engineer("Bob",new MyDate(1997, 5, 12), 45000.0,"C++", 100));
		eService.addEmployee(new Secretary("Peter", new MyDate(2000, 4, 3), 35000.0, "Jane"));
		System.out.println("============ Employee 정보확인 ============ ");
		System.out.println(eService.printEmployee());
		
		
		System.out.println("\n============ 2. deleteEmployee(Bob 삭제) ============ ");
		eService.deleteEmployee("Bob");
		System.out.println("============ Employee 정보확인 ============ ");
		System.out.println(eService.printEmployee());
		
		
		System.out.println("\n============ 3. updateEmployee(Peter 연봉 35000-> 60000상승) ============ ");
		eService.addEmployee(new Secretary("Peter", new MyDate(2000, 4, 3), 60000.0, "Jane"));
		System.out.println("============ Employee 정보확인 ============ ");
		System.out.println(eService.printEmployee());
		
		
		System.out.println("\n============ 4. searchEngineer() ============ ");
		for( Employee e : eService.searchEngineer()) {
			if(e == null)break;
			System.out.println(e.getDetails());
		}
		
		//부서 별 인원수 출력하기
		System.out.println("\n============ 5. Employee Type 별 인원수  출력 ============");
		System.out.println(eService.printEmployee());
		int[] typeCnt = eService.employeeTypeCnt();
		System.out.println( "Manager 수 : " + typeCnt[0] + ", Engineer 수 :" + typeCnt[1] + ", Secretary 수 :" + typeCnt[2]);
	

	}
}







