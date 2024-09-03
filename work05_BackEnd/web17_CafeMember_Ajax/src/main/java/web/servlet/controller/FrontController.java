package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemeberDAOImpl;


@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//로직은 여기서 작성할 것, 한글 처리는 filter에서 등록돼 있다.
		
		//1. command 값 받아오기
		String command = request.getParameter("command");
		String path = "";
		
		if(command.equals("find")) path = find(request, response);
		else if(command.equals("login"))  path = login(request, response);
		else if(command.equals("register"))  path = register(request, response);
		else if(command.equals("showAll"))  path = showAll(request, response);
		else if(command.equals("logout"))  path = logout(request, response);
		else if(command.equals("idCheck"))  path = idCheck(request, response);
		
		System.out.println(path);
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
	private String idCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean find  = false;
		try {
			
			//PrintWriter out = response.getWriter();
			
			//폼값 받아서 
			//비즈니스 로직 호출 -> T/F 리턴 idExist()
			String id = request.getParameter("userId");
			
			find = MemeberDAOImpl.getInstance().idExist(id);
			request.setAttribute("find", find);
			
			System.out.println(id + ", " + find);
			
			return "idCheck_result.jsp";
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "idCheck_result.jsp";
	}
	
	private String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "login.jsp";
		
		try {
			
			//세션을 죽이는 로직 + path를 logout.jsp로 변경
			HttpSession session= request.getSession();
			
			if( session.getAttribute("vo") != null) { // 로그인이 돼있다면 
				session.invalidate();
				path = "logout.jsp";
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return path;
	}
	
	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		try {
			
			Member rvo= MemeberDAOImpl.getInstance().findByIdMember(id);
			
			if(rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}	
			
		}catch (SQLException e) {
		
		}
		
		//request.getRequestDispatcher(path).forward(request, response);
		return path;
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path = "index.html";
		
		try {
			Member rvo = MemeberDAOImpl.getInstance().login(id, pass);
			
			HttpSession session = request.getSession();

			if(rvo !=null) {
				
				System.out.println("로그인 정보 찾음");
				session.setAttribute("vo", rvo);
				System.out.println("LoginServlet ... JSESSIONID :: " + session.getId());
				
				path = "login_result.jsp";
			}
						
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			path = "login_fail.jsp";
		}
		
		return path;	
		
	}
	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Member pvo = null;
		
		if(name.equals(" ") || address.equals(" ")) {
			pvo = new Member(id, password);
		}
		else {
			pvo= new Member(id, password, name, address);
		}
		String path = "index.jsp";
		
		try {

			MemeberDAOImpl.getInstance().registerMember(pvo);
			
			path = "register_result.jsp";	
	
		} catch (SQLException e) {
		
		}
		
		return path;
	}
	private String showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path ="";
		try {

			ArrayList<Member> list= MemeberDAOImpl.getInstance().showAllMember();
			
			request.setAttribute("list", list);
			path = "allView.jsp";
	
		} catch (SQLException e) {
		
		}
		
		return path;
	}
	
}
