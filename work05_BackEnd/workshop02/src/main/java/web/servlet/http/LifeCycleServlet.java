package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/LifeCycleServlet"},
			loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LifeCycleServlet() {
    	System.out.println("LifeCycleServlet() is called!!!");
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() is called!!!");
	}

	public void destroy() {
		System.out.println("destroy() is called!!!");	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() is called!!!");

		/* 1.LifeCycleServlet 화면에 띄우기 */
		//한글 처리		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html></body><h2>");
		out.println("안녕하세요, LifeCycleServlet 입니다.");
		out.println("</h2></body></html>");
		
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
