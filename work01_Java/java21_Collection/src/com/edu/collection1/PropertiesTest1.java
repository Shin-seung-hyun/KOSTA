package com.edu.collection1;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * System 위에 탑재된 자바 관련된 환경변수들이 어떤 값ㄷ르이 있는지
 * 전부 다 가져와서 콘솔로 출력해보자
 */
public class PropertiesTest1 {

	public static void main(String[] args) {
		
		//1. Properties의 부모는 Map이기에 key value가 있음
		Properties p = System.getProperties();
		
		//key를 뽑고
		Enumeration en =  p.propertyNames();

		
		//1. Enumeration 방식 (오래된 방식)
		//key에 해당하는 값을 뽑는다.
		while(en.hasMoreElements()) {
			
			String key = (String)en.nextElement();
			
			String value = (String)p.get(key);
		
			System.out.println( key + " ========== " + value);
		}
		
		//2. Iteraotr 방식
		Set set = p.keySet();
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			//String value = p.getProperty(key);
			String value = (String)p.get(key);
			
			System.out.println( key + " ========== " + value);
			
		}
		
		
		//2-1. 방식 (최신 방식)
		Iterator iterator = p.keySet().iterator();
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			//String value = p.getProperty(key);
			String value = (String)p.get(key);
			
			System.out.println( key + " ========== " + value);
		
		}
		
		//3. for 방식	
		for(Object key : p.keySet()) {
			String value = (String)p.get(key);
			System.out.println( key + " ========== " + value);
		}
		
		//3-1. for each 방식 : 람다식을 사용. java 1.8 버전 이상에서만 사용 가능 (최신식 방식)
		p.forEach( (key,value) -> 
			
			System.out.println( key + " ========== " + value) // p.forEach(); 임으로 ()안에 있을 때는 ; 를 안 써도 됨
		);
		
		
	}

}
