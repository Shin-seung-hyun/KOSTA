package com.edu.test;

import com.edu.service.HRService;
import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

public class HRServiceTest {

	public static void main(String[] args) {
		
		HRService service = new HRService(5);
		
		Engineer e1 = new Engineer("James", 30000.0, "Java", new MyDate(1998, 1, 1));
		Engineer e2 = new Engineer("Juliet", 45000.0, "Python", new MyDate(1997, 3, 11));
		Engineer e3 = new Engineer("Tomas", 53000.0, "AI", new MyDate(1990, 2, 1));
		
		SalesMan s = new SalesMan("Peter", 56666, 1000, new MyDate(1992, 3, 1));
		
	//서비스 기능 호출
		
		//1) 엔지니어를 추가하는 기능
		System.out.println("======= 1. addEmployee =======");
		service.addEmployee(e1);
		service.addEmployee(e2);
		service.addEmployee(e3);
	
		//2) 영업사원을 추가하는 기능
		service.addEmployee(s);
		
		
		System.out.println("\n======= 2. Employee 정보 확인 =======");
		service.printEngineer();
		service.printSalesMan();
		
		//3) 엔지니어의 정보를 수정하는 기능
		System.out.println("\n======= 3. updateEmployee Engineer =======");
		
		service.updateEmployee(new Engineer("Juliet", 55000.0, "React", new MyDate(1997,3,1)));
//		e2 = new Engineer("Juliet", 55000.0, "React", new MyDate(1997,3,1));
//		service.updateEmployee(e2);
		
		
		System.out.println("\n======= 4. Employee 정보 확인 =======");
		service.printEngineer();
		service.printSalesMan();
		
		//5) 특정한 엔지니어를 검색하는 기능
		System.out.println("========== 5.searchEmployee  Tomas==================");
		Engineer returnEngineer=service.searchEmployee("Tomas");
		System.out.println(returnEngineer.getDetails());


		
	}

}
