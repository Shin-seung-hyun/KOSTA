package self.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import self.vo.Student;

public class StudentCollectionTest {
	public static void main(String[] args) {
		
		
		List<Student> totalList = new ArrayList< >();
		totalList.add(new Student("전현무", "남", 92));
		totalList.add(new Student("한혜진", "여", 87));
		totalList.add(new Student("이장우", "남", 95));
		totalList.add(new Student("박나래", "여", 93));
		
		//1. 남학생만 묶어 List 생성
			
		List<Student> maleList = totalList.stream()
										.filter(i-> i.getGender().equals("남"))
										.toList();
	
		 maleList.forEach(i-> System.out.println(i));
	
		
		System.out.println("\n--------------------------------------\n");
		
		//2. 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기..학생의 이름과 성적을 출력
		System.out.println("정렬 방법1");
		totalList.stream()
				.sorted((o1, o2) -> o1.getScore() - o2.getScore())
				.forEach(System.out::println);
		
		System.out.println("\n정렬 방법2");
		totalList.stream()
				.sorted(Comparator.comparing(Student::getScore))
				.forEach(System.out::println);
				
		
		System.out.println("\n--------------------------------------\n");
		
		//3. 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기..학생의 이름과 성적을 출력
		totalList.stream()
				.sorted(Comparator.comparing(Student::getScore).reversed())
				.forEach(System.out::println);
		
		
		System.out.println("\n--------------------------------------\n");
		
		//4. 학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
		//   Collectors.toMap()을 사용
		Map<String, Integer> map = totalList.stream()
											.collect(Collectors.toMap(Student::getName, Student::getScore));
		
		map.forEach((k,v)-> System.out.println(k+"= "+v));

	}
}
