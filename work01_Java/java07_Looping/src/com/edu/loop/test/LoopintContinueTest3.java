package com.edu.loop.test;

public class LoopintContinueTest3 {

	public static void main(String[] args) {
		
		//조건에 해당하는 구간은 건너뛰면서 반복은 계속 한다.

		int sum =0;
		for(int i = 1; i<=100; i++) {
			if( i%2 == 0) continue;
			sum += i;
			System.out.println(i +" ");
		}
		
		System.out.printf("1-100까지 홀수의 총합은 %d 이다. ", sum);
	}

}
