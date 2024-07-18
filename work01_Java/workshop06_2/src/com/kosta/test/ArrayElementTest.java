package com.kosta.test;

import java.util.Arrays;

public class ArrayElementTest {

	public static void main(String[] args) {
		
		double[] salaries = {
				30000.0, 450000.0, 570000.0
		};
		
		System.out.println(salaries); //[D@3d012ddd
		
		// 객체를 가리키는 참조 변수는 toString은 주소값을 반환하다.
		System.out.println(salaries.toString()); //[D@3d012ddd
		
		//배열 안에 있는 여러개의 값들을 출력할 때, 사용하는 라이브러리 Arrays.toString();
		//이걸 쓰면 for문을 안써도 됨
		System.out.println(Arrays.toString(salaries));
	
		
	}

}
