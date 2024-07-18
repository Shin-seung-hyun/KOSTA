package com.edu.array.test2;

/*
 	최고, 최저 성적을 구하라
 	
*/
public class ArrayMaxAndMinTest3 {

	public static void main(String[] args) {
		
		int[] scores = {79, 88, 91, 45, 100, 58, 91};
		
		//min, max의 값을 100, 0과 같이 임의의 값을 넣는 것은 위험하다.
		// scores[0]과 같이 배열의 첫번재 값을 넣어야 한다.
		int max = scores[0];	//배열의 첫번째 값으로 최대값을 초기화
		int min = scores[0];	//배열의 첫번째 값으로 최소값을 초기화한다.
		
		
		for(int i : scores) {
			
			if(i > max) max = i;
			if(i < min) min = i;
		}
		
		System.out.println("최대값 :" + max);
		System.out.println("최소값 :" + min);
		
	}

}
