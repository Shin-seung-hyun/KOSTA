package com.edu.test;

import java.util.Arrays;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest2 {

	public static void main(String[] args) {
		//Heterogeneous Collection
		Employee[ ] employees = {
				new Manager("James", 30000.0, new MyDate(1999, 1, 1), "IT"),
				new Engineer("Tomas", 45000.0, new MyDate(1997, 3, 12),"Java",100 ),
				new Secretary("Peter", 35000.0, new MyDate(2000, 4, 3),"James"),
				new Manager("James2", 30000.0, new MyDate(1999, 3, 1), "IT2"),
				new Engineer("Tomas2", 45000.0, new MyDate(1997, 5, 12),"Java2",100 )				
		};
		
		for(Employee e : employees)
			System.out.println(e.getDetails());
		
		//배열안에 들어있는 데이타 요소를 출력...Arrays.toString()
		System.out.println(Arrays.toString(employees));
		
		System.out.println("\n======== employees 안에서 관리되는 직원들을 연봉 :: 잘못된 결과==============");
		int annualSalary = 0;
		for(Employee e : employees) {
			annualSalary = (int) ((double)e.getSalary() * 12);
			System.out.println(e.getName()+" 님의 연봉은 "+annualSalary+"  달러 입니다.");
		}
		
		
		System.out.println("\n======== employees 안에서 관리되는 직원들을 연봉 :: Success==============");
		int total = 0;
		for(Employee e : employees) {
			if(e instanceof Engineer) {
				total = (int) ((double)e.getSalary() * 12)+ ((Engineer) e).getBonus();
			}else {
				total = (int) ((double)e.getSalary() * 12);
			}			
			
			System.out.println(e.getName()+" 님의 연봉은 "+total+"  달러 입니다.");
		}
	}//main
}//class