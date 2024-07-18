package com.self.service;

import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeService {
	Manager[ ] ms;
	int midx;
	
	Engineer[ ] egs;
	int egidx;	

	private static EmployeeService emService = new EmployeeService(5);
	
	public EmployeeService(int size){
		ms = new Manager[size];
		egs = new Engineer[size];
	}
	
	public static EmployeeService getInstance() {
		return emService;
	}

	
	public void addEmployee(Manager m) {	
		ms[midx++] = m;
	}
	public void addEmployee(Engineer eg) {	
		egs[egidx++] = eg;
	}
	public void deleteManager(String name) {
		
		for(int i=0; i<midx; i++) {
			if(ms[i].getName().contains(name)){
				
				for(int j=i; j<midx-1; j++) {
					ms[j] = ms[j+1];
				}
				ms[midx-1] = null;
				midx--;
				break;
			}
		}
		
	}
	public void deleteEngineer(String name) {
		
		for(int i=0; i<egidx; i++) {
			if(egs[i].getName().equals(name)) {
				
				for(int j=i; j<egidx-1; j++) {
					egs[j] = egs[j+1];
				}
				
				egs[egidx-1] = null;
				egidx--;
				break;
			}
		}
	}
	public void updateEmployee(Manager m) {	
		
		for(int i=0; i<midx; i++) {
			if(ms[i].getName().equals(m.getName())) {
				ms[i] = m;
				break;
			}
		}
	}

	
	public void updateEmployee(Engineer eg) {	
		
		for(int i=0; i<egidx; i++) {
			if(egs[i].getName().equals(eg.getName())) {
				egs[i] = eg;
				break;
			}
		}
	}	
	
	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Manager findManager(String name) {
		Manager m = null;
		
		for(int i=0; i<midx; i++) {
			if(ms[i].getName().equals(name)) {
				m = ms[i];
				break;
			}
		}
		
		return m;
	}
	
	public Manager[ ] findManager(int deptno) {
		Manager[ ] temp = new Manager[midx];
		
		int idx = 0;
		for(Manager m : ms) {
			if(m == null) break;
			if(m.getDeptno() == deptno) {
				temp[idx++] = m;
			}
		}
		
		return temp;
	}
	
	public Engineer findEngineer(String name) {
		Engineer eg = null;
		
		for(int i=0; i<egidx; i++) {
			if(egs[i].getName().equals(name)) {
				eg = egs[i];
				break;
			}
		}
		
		return eg;
	}
	
	public void printManagers() {
		String result = "";
		
		for(int i=0; i<midx; i++) {
			result += ms[i].getDetails()+ "\n";
		}
		
		System.out.println(result);
	}
	
	public void printEngineers() {
		String result = "";
		
		for(int i=0; i<egidx; i++) {
			result += egs[i].getDetails()+ "\n";
		}
		
		System.out.println(result);
	}
	
}

