/*
 * step1.
 * 	 void addEngineer(Engineer e){}
 *   void insertSalesMan(SalesMan s){}
 *   void registerAnalyist(Analysis a){}
 *  
 * step2.
 * 	 void addEngineer(Engineer e){}
 *   void addSalesMan(SalesMan s){}
 *   void addAnalysist(Analysis a){}
 *   
 * step3. 메소드 오버로딩
 * 	  void addEmployee(Engineer e){}
 * 	  void addEmployee(SalesMan s){}
 *    void addEmployee(Analysis a){}
 *    
 * step4. 메소드의 갯수를 줄이자(추상화, 상속)
 * 	  void addEmployee(Employee e){}
 *    
 */

package com.edu.service;

import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

/*
 * Engineer, SalesMan 각각의 직원들을 핸들링하는 기능마으로 구성된 Service 클래스
 */ 
public class HRService {
	
	Engineer[] engineers;
	int eidx;
	
	SalesMan[] salesMans;
	int sidx;
	
	public HRService(int size) {
		engineers = new Engineer[size];
		salesMans = new SalesMan[size];
	}
	
	//서비스 기능 정의 : 1. 선언부 2.구현부 + Test
	
	//1) 엔지니어를 추가하는 기능
	public void addEmployee(Engineer e) {
		
		if(eidx == engineers.length) System.out.println("더이상 엔지니어 추가 불가능");
		else {
			engineers[eidx++] = e;
			System.out.println(e.getName() + " 엔지니어 등록 성공");
		}
	}
	
	//2) 영업사원을 추가하는 기능
	public void addEmployee(SalesMan s) {
		
		if(sidx == salesMans.length) System.out.println("더이상 영업사원을  추가 불가능");
		else {
			salesMans[sidx++] = s;
			System.out.println(s.getName() + " 영업사원 등록 성공");
		}
	}
	
	//3) 엔지니어의 정보를 수정하는 기능
	public void updateEmployee(Engineer e) {
		
		for(Engineer engineer : engineers) {
		
			 if(engineer == null) continue;
			 if(engineer.getName().equals(e.getName())){
				 
				 //이름, 생년월일은 수정의 대상이 아님.
				 engineer.changeSalary(e.getSalary());
				 engineer.developMainSkill(e.getMainSkill());
			 }
		
		}
		
	}
	
	//4) 영업사원의 정보를 수정하는 기능
	public void updateEmployee(SalesMan s) {
		for(SalesMan salesMan : salesMans) {
			
			if(salesMan == null) continue;
			if(salesMan.getName().equals(s.getName())) {
				
				salesMan.changeSalary(s.getSalary());
				salesMan.setCommition(s.getCommition());
			}
			
		}
		
		
	}
	
	//5) 특정한 엔지니어를 검색하는 기능
	public Engineer searchEmployee(String name) {
		Engineer engineer = null;
		
		for(Engineer e : engineers) {
			if(e == null) continue;
			if(e.getName().equals(name)) engineer = e;
		}
		
		return engineer;
	}
	
	//정보를 출력하는 기능
	public void printEngineer() {
		
		for(Engineer e : engineers) {
			if(e == null) break;
			System.out.println(e.getDetails());
		}
	}
	
	//정보를 출력하는 기능
	public void printSalesMan() {
		
		for(SalesMan s : salesMans) {
			if(s == null)break;
			System.out.println(s.getDetails());
		}
	}

}
