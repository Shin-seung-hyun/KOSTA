package client;

import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ControllerFactory;

// 서버 상의 client이다.
// FrontController 역할
public class FrontServlet {
	static HttpServletRequest request = null;
	static HttpServletResponse response = null;

	public static void main(String[] args) {
		
		// 폼으로 값을 입력 받는다.
		Scanner sc = new Scanner(System.in);
		System.out.println(">>>> Command 값 입력 : ");
		
		String command = sc.next();
		
		//1. 폼값 전달
		Controller controller=ControllerFactory.getFactory().createController(command);

		//2.
		String path = controller.handel(request, response);
		
		//3.
		System.out.println(path);
		
	}

}
