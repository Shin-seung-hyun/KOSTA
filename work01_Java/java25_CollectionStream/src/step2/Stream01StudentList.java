package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 중간처리 연산자를 공부해보자
	// java.util.stream 내 stream 클래스

/*
 
중간처리 연산자
	 map
	 mapToInt | mapToDouble
	 peek
	 distinct
	 filter
	 limit
 
 */

class Student{
	String name;
	int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
}

public class Stream01StudentList {

	public static void main(String[] args) {
		
		List<Student> students = Arrays.asList( 
				new Student("SCOTT", 90),
				new Student("BLAKE", 92),
				new Student("SMITH", 83)
		);
		
		Stream<Student> studentStream = students.stream();
		
	// 중간처리 연산자 연습
		// 1. mapToInt : 학생 객체를 점수로 매핑해서 IntStream(점수만으로 이뤄진 새로운 스트림)을 반환한다.
		IntStream socreStream =  studentStream.mapToInt(student -> student.getScore());
		double avg =  socreStream.average().getAsDouble(); //중간 처리
		System.out.println("Result AVG1 : " + avg);		// 최종 처리

		// 1-1. 람다에는 어떻게 쓰면 좋을까
		System.out.println("\n==== Method Chaining 기법 ===");
		double avg2 = students.stream()
							.mapToInt(student -> student.getScore())
							.peek(student -> System.out.println(student + " "))
							.average()
							.getAsDouble();
		System.out.println("Result AVG2: " + avg2);	
		
		//[map] Stream 내 값들을 반환해서 새로운 스트림을 생성하는 기능
		System.out.println("\n============= map =============");
		long count =  students.stream()
								.map(student -> student.getName())					
								.peek(student -> System.out.println(student + " "))
								.count();
		
		
		long count2 =  students.stream()
								.map(student -> student.getName())
								.peek(student -> System.out.println(student + " ")) 
								.count();
		
		System.out.println( "학생수 :" + count);
		
		
		System.out.println("\n============= anyMatch(최종처리 연산) | filer(중간처리 연산)와 구분 =============");
		boolean find = students.stream()
								.anyMatch(s -> s.getName().equals("KING"));
		
		System.out.println("King이 존재합니까? :" + find);
		
		
		
        List<String> items = Arrays.asList("apple", "banana", "orange");

        long cnt = items.stream()
                .peek(item -> System.out.println("Processing: " + item)) // 중간 연산, 각 요소를 출력
                .count(); // 최종 연산, 요소의 개수를 셈

        System.out.println("Total items: " + cnt);
		
		
		
	}

}
