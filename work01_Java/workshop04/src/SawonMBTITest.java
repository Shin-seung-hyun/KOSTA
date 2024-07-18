import java.util.Scanner;

public class SawonMBTITest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("K전자 신입사원수 입력 >>> ");
		int num = sc.nextInt();//배열의 사이즈
		int[ ] people =new int[num]; //6
		
	    System.out.println("공백을 기준으로 각 사원에 대한 성격 유형을 직접 입력 >>> ");
		
	    //배열 초기화
		for(int i=0; i<people.length; i++) {
			people[i] = sc.nextInt(); //1,4,4,4,5,3(5가지의 타입이 있음)
		}
			
	// 코드1
		int[] mbtiArr = new int[6];
		
		for(int i =0; i<people.length; i++) {
		
			mbtiArr[people[i]]++;
		}
		
		int maxNum = 0;
		int answer = 0;
		for(int i=0; i<mbtiArr.length; i++) {
			
			//System.out.println(mbtiArr[i]);
		
			if(maxNum < mbtiArr[i]) {
				maxNum = mbtiArr[i];
				answer = i;
			}
		}
		
		System.out.println("정답 :: "+ answer);
		
	// 코드2		
		int answer2 = 0;
		int[] counts = new int[6];
		for (int i : people) { 
			counts[i]++;
			if (answer2 < counts[i]) 
				answer2 = i;
		}
		
		for(int cnt : counts) System.out.println(cnt);
		
		System.out.println("정답 :: "+answer2);
	}
}

