package com.myAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Count {

	public String execute(String book) {

		StringTokenizer st = new StringTokenizer(book.toLowerCase(), " ");

		HashMap<String, Integer>hashMap = new HashMap<>();

		while(st.hasMoreTokens()){
			String key = st.nextToken();
			hashMap.put(key, hashMap.getOrDefault(key,0) +1);
		}
		
	
		List<String> keySet = new ArrayList<>(hashMap.keySet());
		
		keySet.sort((o1, o2) -> {
			int val = hashMap.get(o2).compareTo(hashMap.get(o1));	
			
			if(val ==0) return o1.compareTo(o2);
			else return val;
		});
		
//		for( String key : keySet) {
//			System.out.println("KEY : " + key + "   VALUE : " + hashMap.get(key) );
//		}
		
		return keySet.get(0);
	}

 public static void main(String[] args) {
	 
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";

		Count c = new Count();

		System.out.println(c.execute(book1));
		System.out.println();
		System.out.println(c.execute(book2));
		System.out.println();
		System.out.println(c.execute(book3));

	}

}
