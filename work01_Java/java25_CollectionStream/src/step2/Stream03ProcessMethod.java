package step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
 
 최종처리 연산자
 
 findFirst
 collect
 forEach
 anyMatch
 count
 
 */
public class Stream03ProcessMethod {

	public static void main(String[] args) {
		
		List<String> strings = List.of( "I", "am", "a", "list", "String");
		
		Stream<String> stream = strings.stream();
	    stream = stream.limit(4);
	    //System.out.println(stream); //데이터 안나온다.
										
		//1. Stream 에서 첫번째 데이터를 찾아서 바로 출력
	   	//System.out.println(stream.findFirst().get());
	   	
		//2. Stream 안에 있는 String 테이터의 갯수를 출력
	    //System.out.println(stream.count());
	    
	    //3. Stream 안에 있는 모든 String 데이터를 다 출력
	    //stream.forEach(i -> System.out.print(i + " "));
	    
	    //4. Stream 안에 있는 모든 String 데이터를 수집해서 한번에 출력 collect
	    List<String> result = stream.collect(Collectors.toList());
		System.out.println(result);
	
	
	
	}
	

}
