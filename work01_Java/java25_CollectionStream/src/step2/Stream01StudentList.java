package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 중간처리 연산자를 공부해보자
	// java.util.stream 내 stream 클래스
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
		System.out.println("Result AVG : " + avg);		// 최종 처리

		// 1-1. 람다에는 어떻게 쓰면 좋을까
		System.out.println("\n==== Method Chaining 기법 ===");
		double avg2 = students.stream()
							.mapToInt(student -> student.getScore())
							.average()
							.getAsDouble();
		System.out.println("Result AVG : " + avg2);	
		
		
					
		
	}

}
