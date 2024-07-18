package com.edu.vo.test;

import com.edu.vo.*;

/*
 Test 클래스의 주요 역할
  1. 객체 생성
  2. 메소드 호출
*/

/*
	1. james 라는 개발자를 생성
		tomas 라는 개발자를 생성
		reference 변수로
	
	2. james가 HP 브랜드의 노트북을 구매
		tomas가 LG 브랜드의 노트북을 구매
		
		
	3. tomas가 구매한 노트북의 가격과 브랜드명을 출력
	4. james의 연봉을 출력
	5. tomas의 급여를 인상한 후, 최종적인 연봉을 출력
*/


public class ProgrammerTest {

	public static void main(String[] args) {
		
		//1. 개발자 생성
		Programmer james = new Programmer("james", "Java", 4_000_000.0F, "서울", 500_000);
		Programmer tomas = new Programmer("tomas", "C", 3_500_000.0F, "부산", 100_000);
			
		//2. 노트북 구매
		james.buyNoteBook(new NoteBook(123, "HP", 1_500_000));
		tomas.buyNoteBook(new NoteBook(456, "LG", 1_700_000));
			
		//3. tomas 구매했던 노트북 출력
		System.out.println(james.getNoteBookInfo());
		
		//4. james 연봉 출력
		System.out.println("\n========= jame 연봉===========");
		System.out.println(james.getAnnualSalary());
		
		//5. 연봉인상 + 출력
		tomas.raiseSalary(200_000);
		System.out.println(tomas.getAnnualSalary());
				
	}

}

