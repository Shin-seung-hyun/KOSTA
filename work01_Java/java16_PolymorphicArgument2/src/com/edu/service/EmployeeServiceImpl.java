package com.edu.service;

import com.edu.vo.Employee;
import com.edu.vo.Engineer;

public class EmployeeServiceImpl implements EmployeeService {
	
	//싱글톤 패턴
	static private EmployeeServiceImpl service = new EmployeeServiceImpl();//1
	private EmployeeServiceImpl() {}//2
	public static EmployeeServiceImpl getInstance() { //3
		return service;
	}
	
		
	//1. 모든 Employee[ ]안에 들어있는 객체 정보들을 출력
	public Employee[ ] getAllEmployee(Employee[ ] ea){	
		Employee[ ] temp = new Employee[ea.length];
		int count = 0;
		for(Employee e : ea)temp[count++] = e;			
		
		return temp;
	}
	
	//2.테스트 클래스에서 넘겨받은 empId의 값과 일치하는 객체를 리턴하는 기능
	public Employee findEmployee(Employee[ ] ea, int empId){
		Employee employee = null;
		
		for( Employee e : ea) {
			
			if(e.getEmpId() == empId) {
				employee =e;
				break;
			}
		}
		
		return employee;		
	}
	
	//3. 테스트 클래스에서 넘겨받은 addr값과 일치하는 Employee 타입의 객체를 리턴받음
	public Employee[ ] findEmployee(Employee[ ] ea, String addr){
		
		//동일한 주소에 거주하는 사원의 명수
		int size = 0;
		for(Employee e : ea) {
			if( e.getAddr().equals(addr))size++;
		}
		
		Employee[] addrEmps = new Employee[size];
		for(Employee e : ea) {
			if( e.getAddr().equals(addr)) addrEmps[--size] = e;
		}
		
		return addrEmps;
		
	}
	//4. 특정한 Employee의 연봉을 리턴하는 기능...Engineer일때는 보너스 까지 생각
	public int getAnnualSalary(Employee e){
		int annualSalary = 0;
		
		annualSalary = e.getSalary()*12;
		
		if(e instanceof Engineer) {
			annualSalary += ((Engineer) e).getBonus();
		}
		
		//System.out.println(e);
		return annualSalary;
	}
	
	//5. 연간 총 인건비의 총액을 리턴하는 기능
	public int getTotalCost(Employee[ ] ea){
		int totalCost = 0;
		
		for(Employee e : ea) {
			totalCost += e.getSalary() * 12;
			
			if(e instanceof Engineer) totalCost += ((Engineer) e).getBonus(); 
		}
		return totalCost;
		
	}
	
}





































