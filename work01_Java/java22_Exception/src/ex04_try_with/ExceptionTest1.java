package ex04_try_with;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionTest1 {

	public static void main(String[] args) throws IOException {
		
		FileWriter file = null;
		
		try {
			file = new FileWriter("data.txt"); // 출력용 파일을 자동으로 기본 경로에 생성된다.
			file.write("Hello World");
			
		}finally {
			file.close();
		}
		
		

	}

}
