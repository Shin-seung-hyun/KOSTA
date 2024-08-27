package web.servlet.greet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/GS"},
			loadOnStartup = 1,
			initParams = {@WebInitParam(name = "GREET", value = "Hello Welcome to Olymphic Games")
			})
public class GreetServlet extends HttpServlet{
	private String greet = ""; //Ready on 시점에 받아오기 (클라이언트 요청과는 무관함)
	private String name = "";  //클라이언트 요청 시에 form 값을 받아옴
	
	
	public GreetServlet(){
		System.out.println("1. 서블릿 생성");
		
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("2. ServletConfig 생성 ... init() 호출");
		greet = getInitParameter("GREET"); // 필드 초기화 (새로운 값 할당)
		System.out.println("greet message:: " + greet);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. 클라이언트 요청시 호출 .. HTML 폼 값을 받아온다");
		
		//폼값을 받아와서 브라우저에 출력
		PrintWriter out = response.getWriter();
		name = request.getParameter("name");
		out.println("<html></body><h3>");
		out.println(name + ", " + greet);
		out.println("</h3></body></html>");
		
		out.close();
		
	}
}
