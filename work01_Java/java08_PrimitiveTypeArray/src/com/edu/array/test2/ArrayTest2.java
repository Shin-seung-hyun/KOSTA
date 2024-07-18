package com.edu.array.test2;


//2) 다른 배열의 데이터를 copy해서 사용할 수 있다.
//System.arraycopy(); => static 기능

public class ArrayTest2 {

	public static void main(String[] args) {
		
		int[] target = {1,2,3,4,5,6}; // size 6
		int[] source = {10,9,8,7,6,5,4,3,2,1};
		
		//source 데이터 8,7,6,5,4,3 를 copy해서 target에 처음부터 끝까지 붙이자!
		//before : target = {1,2,3,4,5,6};
		//after : target = {8,7,6,5,4,3};
		
		System.arraycopy(source, 2, target, 0, target.length);
		
		for(int i : target) System.out.println(i);
		
	}
	
	public static void arraycopy(Object src, int srcPos,
						         Object dest, int destPos, int length) {
		
		
	}

}
