package self;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SongsStreamTest {

	public static void main(String[] args) {
		List<Song> songs = new Songs().getSongs();
		
		/*
		 1.  수집하기 - 중간처리 filter | 최종처리 collect
			 스트림으로 만들어서 함수 적용
			 노래의 쟝르 중에서 Rock인 쟝르만 추출
			 정보를 출력한다.
		*/		
		
		System.out.println("======= 1. Rock인 장르 추출 ===========");
		List<Song> rockSong = songs.stream()
									.filter(i -> i.getGenre().equals("Rock"))
									.collect(Collectors.toList());
		System.out.println(rockSong);
		
				
		/*
		  2.  존재여부 확인하기 - 최종처리 anyMatch
		      노래의 장르중에서 R&B장르가 있는지 여부를 확인하고 출력한다.
		      filter 는 true 인 것만 반환
		      anyMatch 있으면 true/ 없으면 flase 반환
		 */		
		
		System.out.println("\n======= 2. R&B 장르 확인 ===========");
		boolean result = songs.stream()
								.anyMatch(i-> i.getGenre().equals("R&B"));
		System.out.println(result);
						
			
		 /*
		   3.  항목 갯수세기 - 중간 처리 map, peek, distinct | 최종 처리 count
		       아티스트정보 만으로 새로운 스트림을 만들고 (map)
		       정보들을 뽑아서 먼저 중간출력을 해본다.
		       중복된 정보들이 있으면 제거하고
		       아티스트 갯수를 출력한다.		       
		 */		
		System.out.println("\n======= 3. 아티스트 갯수 출력 ===========");
		long result1 = songs.stream()
							.map(a -> a.getArtist())
							.peek(i-> System.out.println(i))
							.distinct()
							.count();
		System.out.println(result1);
					
		
		 /*
		    4. 1995년도에 발매된 노래만 추출해서 그 중에서 첫번째 노래를 찾아서 정보를 출력
		 */
		
		System.out.println("\n======= 4.1995년도에 발매된 노래 추출해서 한 개 출력 ===========");
		
		//방법1)
		songs.stream()
			  .filter(i -> i.getYear() == 1995 )
			  .limit(1)
			  .forEach(System.out::print);
		
		//방법2)
		Optional<Song> findSong2 = songs.stream()
										.filter(i -> i.getYear() == 1995)
										.findFirst();
		System.out.println(findSong2);
		
		//방법3)
		Optional<Song> result3 = songs.stream()
										.filter(s-> s.getYear() == 1995)
										.findFirst();
		
		if(result3.isPresent()) 
			 System.out.println(result3.get());
		else
			System.out.println("해당 년도의 노래는 찾을수 없습니다.");	
		
		
		System.out.println("\n================= Optional의 예외처리1 =========================");
		Song song1995 = songs.stream()
							.filter(s-> s.getYear() == 1995)
							.findFirst()
							.orElseThrow( RuntimeException :: new); //findFirst가 없으면 예외 처리를 하겠다.
		System.out.println(song1995);
		
		
		System.out.println("\n================= Optional  =========================");
		List<Song> firstSong = songs.stream()
									.filter(s-> s.getYear() == 1995)
									.limit(1)
									.collect(Collectors.toList());
		
		System.out.println(firstSong);
				
				
				
		
	}
}







