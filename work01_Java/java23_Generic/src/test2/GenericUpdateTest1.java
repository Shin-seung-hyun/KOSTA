package test2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * 해당 코드에서는 Generic 기법을 사용하다.
 * 1. 장점 : 모든지 Box에 담을 수 있다.
 * 2. 단점 : 꺼낼 때, Object Casting을 안하고 효율적으로 꺼낼 수 있다.
 */

class Box<T>{ // T라는 클래스는 실제로 존재하지 않고, T는 Type을 의미한다.
	T content; // Box에는 T타입의 내용물이 담겨진다. T 타입은 나중에(객체 생성시, 사용시에) 구체적인 타입으로 대체된다.
	
	public T selectContent() {
		return content;
	}	
}

public class GenericUpdateTest1 {
	public static void main(String[] args) {

		//Object Casting 필요 없음
		Box<String> box = new Box<>();
		box.content = "곰인형";
		
		String bear = box.selectContent();
		System.out.println("담겨진 것은 " + bear); 	// Object Casting을 할 필요 없다.

		//우리가 제너릭을 어떻게 썼는지 알아보자!
		// public interface List<E> extends Collection<E> {}
		//Boxing UnBoxing 예시
		List<Integer> list = new ArrayList<>();
		list.add(new Integer(10));
		list.add(20);	// Auto Boxing : 알아서 Integer 값을 만들어주고 넣어줌 
						// list.add(new Integer(10) + 출력할 때 intValue() 를 자동으로 해줌
						// 그러나, 대용량 데이터를 사용할 때 위와 같이하면 우린 편하지만 비효율적이라 성능에 문제가 생긴다.
		list.add(30);
		
		System.out.println(list); // UnBoxing
	}
	
}
