package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 
 Lazy Loading
 Ready on 상태의 작업들이 첫번재 클라이언트가 요청하면 그때 함께 동작한다.
 
 PreLoading
 Ready on 상태의 작업들이 클라이언트 요청하기 전에 미리 메모리에 올라가서 setting 된다.
 이렇게 작업이 진행되기 위해서는 주문서에 옵션을 추가해야 한다.
 <load-on-startup> 1 </load-on-startup> 
 
 */

//@WebServlet("/Life")
@WebServlet(urlPatterns = {"/Life"}, loadOnStartup = 1) // preloading 설정
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 필드 추가
	private int count = 0;
       

/*  Ready on 상태 : 기본 생성자, init()
 	process 한 번만 실행 됨
 */	
    public LifeServlet() {
    	System.out.println("1. 서블릿 인스턴스 생성 ... by Container");
    }
	public void init() throws ServletException {
		System.out.println("2. init() 메소드 호출 ... by Container");
	}

	public void destroy() {
		System.out.println("4. destroy() 메소드 호출 ... by Container");
	}

/*  브라우저의 호출 시 실행
  	thread : 브라우저 호출 시 실행
 */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("3. doGet() 메소드 호출 ... by Container");
		
		// 클라이언트의 요청을 처리
		PrintWriter outPrintWriter  = response.getWriter();
		outPrintWriter.println("<html><body bgcolor=yellow>");
		outPrintWriter.println("<h2>LifeCycle CallBack Method ... </h2>");
		outPrintWriter.println("<b>Count :: " + ++count + "</b>");
		outPrintWriter.println("</body></html>");
		
		outPrintWriter.close();
	}

}
