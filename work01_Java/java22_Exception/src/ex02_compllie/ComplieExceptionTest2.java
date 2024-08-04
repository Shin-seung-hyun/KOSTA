package ex02_compllie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading2{
	public void readFile(String fileName) {

		System.out.println("2. readFile calling...");

		FileReader reader = null;
		try {
			reader = new FileReader(fileName);
			System.out.println("파일을 성공적으로 찾았습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
			System.out.println(e);
			//e.printStackTrace();
		}
		finally {
			try {
				System.out.println("자원 반환...");
				reader.close();
			} catch (IOException e) {
				System.out.println(e + ", catch");
			}
		}
		
	}
}

public class ComplieExceptionTest2 {

	public static void main(String[] args) {
		System.out.println("1. FileReading 객체 생성...");
		FileReading2 fr = new FileReading2();

		fr.readFile("test1.txt");

		System.out.println("3. 파일을 잘 읽어들였습니다.");
	}

}
