package com.edu.collection2;

import java.util.Set;
import java.util.TreeSet;

/*
 * Set
 * 	  1. HashSet (중복 X, )
 * 	  2. TreeSet (중복 X, 정렬 O)
 */
public class TreeSetTest2 {

	public static void main(String[] args) {
		
		TreeSet set = new TreeSet();
		
//		set.add("BBB");
//		set.add("CCC");
//		set.add("AAA");
//		set.add("PPP");
//		set.add("BBB");
//		
//		System.out.println(set);
		
		set.add(new Integer(11));
		set.add(22);	 //Boxing
		set.add(3);
		set.add(10);
		set.add(20);
		set.add(100);
		System.out.println(set.higher(10)); //11
		System.out.println(set.lower(100)); //22
		System.out.println(set.headSet(20));	//[3, 10, 11]
		System.out.println(set.tailSet(20));	//[20, 22, 100]
		
	}

}
