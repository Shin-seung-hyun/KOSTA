package com.edu.array.test1;


/*
 * 배열 : same data type
 	선언 + 생성 + 초기화 => 동시에
 */
public class BasicArrayTest3 {

	public static void main(String[] args) {

		//1)선언 + 2)생성  + 3)초기화
			// 1)2)3)을 한번에 해도 묵시적 초기화로 0으로 초기화되고
			// {95,78, ..} 값이 할당 됨.
		int[] scores = {95, 78, 66, 90, 87};
		
		int sum =0;
		for(int score : scores) {
			
			sum += score;
		}
		
		System.out.println( "성적들의 총합 : "+sum);
		System.out.println( "성적들의 평균 : "+ sum /scores.length);
		
	}

}
