package ex02_compllie;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	public void readFile(String fileName) {

		System.out.println("2. readFile calling...");
		
		//자바에서 파일을 읽어들이기 위해서는 FileReader 객체를 생성
		//FileReader reader = new FileReader(fileName); //error 발생
	
		try {
			FileReader reader = new FileReader(fileName);
			System.out.println("파일을 성공적으로 찾았습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
			System.out.println(e);
			//e.printStackTrace();
		}
		
	}
}

public class ComplieExceptionTest1 {

	public static void main(String[] args) {
		System.out.println("1. FileReading 객체 생성...");
		FileReading fr = new FileReading();

		fr.readFile("test1.txt");

		System.out.println("3. 파일을 잘 읽어들였습니다.");
	}

}
