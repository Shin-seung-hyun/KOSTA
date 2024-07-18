package com.self.service;

import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;
import com.self.vo.Secretary;

public class EmployeeService {
	
	private Employee[] employees;
	private int eidx;
	
	private static EmployeeService emService = new EmployeeService(10);
	
	
	private EmployeeService(int size) {
		
		employees = new Employee[size];
	}
	
	public static EmployeeService getInstance() {
	
		return emService;
	}
	
	
	//Create
	public void addEmployee(Employee e) {
		
		employees[eidx++] = e;
	}
	
	//Read
	public Employee[] searchEngineer() {
		Employee[] tmp = new Employee[eidx];
		
		int idx=0;
		for(Employee e : employees) {
			if(e == null) break;
			
			if( e instanceof Engineer) {
				tmp[idx++] = e;
			}
		}
	
		return tmp;
	}
	
	public Employee[] searchManager() {
		Employee[] tmp = new Employee[eidx];
		
		int idx=0;
		for(Employee e : employees) {
			if(e == null) break;
			
			if( e instanceof Manager) {
				tmp[idx++] = e;
			}
		}
	
		return tmp;
	}

	
	public Employee[] searchSecretary() {
		Employee[] tmp = new Employee[eidx];
		
		int idx=0;
		for(Employee e : employees) {
			if(e == null) break;
			
			if( e instanceof Secretary) {
				tmp[idx++] = e;
			}
		}
	
		return tmp;
	}
	
	//Update
	public void updateEmployee(Employee e) {
		for(Employee tmp : employees) {
		
			if(tmp.getName().equals(e.getName()))
				tmp = e;	
		}
	}
	
	//Delete
	public void deleteEmployee(String name) {
		
		for(int i=0; i<eidx; i++) {
			
			if(employees[i].getName().equals(name)) {
				
				for(int j =i; i<employees.length-1; i++) {
					employees[j] = employees[j+1];
				}
				employees[eidx-1] = null;
				eidx--;
				break;
			}
		}
		
	}
	
	public int[] employeeTypeCnt() {
		
		int[] typeCnt = new int[3];
		
		for(Employee e : employees) {
			
			if(e == null) break;
			
			if(e instanceof Manager) typeCnt[0]++;
			if(e instanceof Engineer) typeCnt[1]++;
			if(e instanceof Secretary) typeCnt[2]++;
			
		}
		return typeCnt;
	}
	
	
	public String printEmployee() {
		
		String str = "";
		for(int i=0; i<eidx; i++) {
			str += employees[i].getDetails() +"\n";
		}
		return str;
		
	}
	
	
}

