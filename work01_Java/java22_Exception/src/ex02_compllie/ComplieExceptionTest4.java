package ex02_compllie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading4{
	public void readFile(String fileName) throws FileNotFoundException, IOException { // 2. readFile 을 호출한 지점으로 폭탄이 감.

		System.out.println("2. readFile calling...");

		FileReader reader = null;
		try {
			reader = new FileReader(fileName); // 1. FileNotFoundException로 던짐
			System.out.println("파일을 성공적으로 찾았습니다.");
			
		} 
		finally {
			System.out.println("자원 반환...");
			reader.close(); // 1. IOException 으로 던짐
		}

	}
}

public class ComplieExceptionTest4 {

	public static void main(String[] args) throws IOException{ // 3. JVM이 처리
		System.out.println("1. FileReading 객체 생성...");
		FileReading4 fr = new FileReading4();

		fr.readFile("test.txt"); 

		System.out.println("3. 파일을 잘 읽어들였습니다.");
	}

}
