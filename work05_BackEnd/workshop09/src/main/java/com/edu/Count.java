package com.edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Count {

	static StringTokenizer st;
	
	
	public String execute(String book) {
		
		HashMap<String, Integer>hashMap = new HashMap<>();
		
		st = new StringTokenizer(book, " ");
		
		while(st.hasMoreTokens()){
			String key = st.nextToken();
			hashMap.put(key, hashMap.getOrDefault(key,0) +1);
		}
		
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hashMap.entrySet());

		entryList.sort(Map.Entry.comparingByValue());

//		for(Map.Entry<String, Integer> entry : entryList){
//		    System.out.println("key : " + entry.getKey() + " Value : " + entry.getValue());
//		}
		
		return entryList.get(entryList.size()-1).getKey();
	}

 public static void main(String[] args) {
	 
	 	
	 
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
