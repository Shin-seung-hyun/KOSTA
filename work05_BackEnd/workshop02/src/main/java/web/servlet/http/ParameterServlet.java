package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParameterServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//2. PrintWriter 객체 반환
		PrintWriter out = response.getWriter();
		
		//3. 폼값 받아서
		String job = request.getParameter("job");
		String pageNo = request.getParameter("pageNo");
		String searchWord = request.getParameter("searchWord");
		
		//4.웹 브라우저에 출력
//		out.println("<html></body>");
//		out.println("<h3>job : " + job + "</h3>");
//		out.println("<h3>pageNo : " + pageNo + "</h3>");
//		out.println("<h3>searchWord : " + searchWord + "</h3>");
//		out.println("</h3></body></html>");
//		
		
		StringBuilder sb = new StringBuilder();
		sb.append("<h2> job : ").append(job).append("</h2>");
		sb.append("<h2> pageNo : ").append(pageNo).append("</h2>");
		sb.append("<h2> searchWord : ").append(searchWord).append("</h2>");
		
		out.println("<h1> Get 방식으로 받은 정보를 출력합니다.</h1>");
		out.println(sb);
		
		out.close();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//2. PrintWriter 객체 반환
		PrintWriter out = response.getWriter();
		
		//3. 폼값 받아서
		String name = request.getParameter("name");
		String email = request.getParameter("email");		
		String gender = request.getParameter("gender");	
		
		String[] hobby = request.getParameterValues("hobby");
		
		StringBuilder sbHobby = new StringBuilder();
		for(String h : hobby) {
			sbHobby.append(h).append(", ");
		}
		
		//System.out.println(sbHobby + ", " +sbHobby.length());
		
		sbHobby.setLength(sbHobby.length()-2);
		
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");	
		
		StringBuilder sb = new StringBuilder();
		sb.append("<h3>name : ").append(name).append("</h3>");
		sb.append("<h3>email : ").append(email).append("</h3>");
		sb.append("<h3>gender : ").append(gender).append("</h3>");
		sb.append("<h3>hobby : ").append(hobby).append("</h3>");
		sb.append("<h3>favorite : ").append(favorite).append("</h3>");
		sb.append("<h3>desc : ").append(desc).append("</h3>");
		
		out.append(sb);
			
	}
}
