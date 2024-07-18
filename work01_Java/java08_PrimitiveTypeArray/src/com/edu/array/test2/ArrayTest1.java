package com.edu.array.test2;

//1) 배열의 사이즈는 변경할 수 없다.
public class ArrayTest1 {

	public static void main(String[] args) {
		
		//안되는 이유 : 
		// 배열은 한번 잡은 사이즈는 바뀔 수 없다.
		// 사이즈를 변경하는 순간 새로운 배열(객체)이 만들어진다.
		int[] members = {1,2,3,4,5};
		
		members = new int[8];
		members[5] = 6;
		members[6] = 7;
		members[7] = 8;
		
		for(int member : members) System.out.println(member + " "); //0 0 0 0 0 6 7 8

		
		
		
	}

}
