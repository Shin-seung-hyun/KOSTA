package ex04_try_with;


import java.io.BufferedReader;

//try with resource 구문 활용하기

/*
 * try(자원을 열어서 생성하는 코드들 작성) 
 * close를 호출하지 않아도 자동으로 try 블럭을 벗어나는 순간 무조건 close가 호출 되는 기법이다.
 * 그런 다음에 catch 블럭이 차레로 수행된다.
 * 만약, try() 괄호 안에 다른 Stream을 생성해서 여려 개 넣을 수도 있다. ; 세미콜론으로 구분만 하면 된다.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest2 {

	public static void main(String[] args){
		
		
		try(FileWriter file = new FileWriter("data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			file.write("Hello World");
			System.out.println("파일 출력");
			
		}catch (IOException e) { // finally가 없기에 throws 할 필요 없기 catch로 잡으면 됨
			System.out.println("잡았당");
		}
		
		
	}

}
