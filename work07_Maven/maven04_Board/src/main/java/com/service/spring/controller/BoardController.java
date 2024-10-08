package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;
import com.service.spring.service.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write.do")
	public String write( Board bvo , HttpSession session, Model model) {
		
		try {
			Member mvo = (Member) session.getAttribute("mvo");
			
			if(mvo == null) return "redirect:index.jsp";
			else{
				
				bvo.setMemberVO(mvo);
				model.addAttribute("bvo",bvo);
				boardService.write(bvo); // 인자값으로 들어옹ㄴ bvo와는 다르다
				
				return "board/show_content";
			}
			
		} catch (Exception e) {
			model.addAttribute("message", "Board 게시글 작성 - 에러발생");
			System.out.println(e.getMessage());
			
			return "Error";
		}
				
	}
	
	
	@RequestMapping("list.do")
	public String list( Model model) {
		
		try {
			
			List<Board> list = boardService.getBoardList();
			model.addAttribute("list", list);
		
			return "board/list"; //InternalResourceViewResolver의 영향을 받는다.
			
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
			
			model.addAttribute("message", "Board - 게시글 검색 중 에러 발생");
			return "Error";
		}
		
	}
	
	@RequestMapping("showContent.do")
	public String showDetail( int no, HttpSession session, Model model) {
		
		if(session.getAttribute("mvo") == null) 
			return "redirect:index.jsp";
		
		try {
			//1. 로그인한 사람만이 볼 수 있다
			//	  조회수 증가
			//2. 글쓴 사람의 id 이면 수정/삭제 권한 부여
			boardService.updateCount(no); // 상세글 보려할 때, count++
			Board bvo = boardService.showContent(no);
			
			model.addAttribute("bvo", bvo);
			
			return "board/show_content";
			
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
			
			model.addAttribute("message", "Board - 게시글 상세보기 중 에러 발생");
			return "Error";
		}
	}
	
	
/*
 * do는 행위를 한다는 것이다.
 * doLogin : 해당 메소드에서 직접 로그인 기능이 나온다.
 * login : 해당 메소드를 실행하면 로그인할 수 있는 폼이 나온다.
 */
	
	@RequestMapping("delete.do")
	public String doDelete(int no, Model model) {
		
		
	/* forward 방식 : http://localhost:8888/spring/delete.do?no= */
//		try {
//			boardService.deleteBoard(no);
//			List<Board>list = boardService.getBoardList();
//			
//			model.addAttribute("list", list); //forwarding
//			
//			return "board/list";
//		
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//			
//			model.addAttribute("message", "Board - 게시글 삭제 중 에러 발생");
//			return "Error";
//		}
		
	/* redirect 방식 : http://localhost:8888/spring/list.do?no= */	
		try {
			boardService.deleteBoard(no);
			return "redirect:list.do"; //redirect
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
			model.addAttribute("message", "Board - 게시글 삭제 중 에러 발생");
			return "Error";
		}
		
	}
	
	
	@RequestMapping("updateView.do")
	public String update(int no, Model model) { //update.jsp가 결과 페이지 
		
		try {
			// 진짜 수정이 진행되는 것이 아니라 updateBoard()가 호출되는 것이 아니라
			// 폼 안에 bvo 값이 들어간 상태에서 그 값을 부분 수정하는 것이다.
				// no에 해당하는 bvo 값을 받아오려면..?
				//bvo 값을 바인딩한 상태에서 update.jsp 결과 페이지와 연결돼야 한다.
			
			Board bvo = boardService.showContent(no);
			
			model.addAttribute("bvo", bvo);
			
			return "board/update";
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
			model.addAttribute("message", "Board - 게시글 수정 폼 이동중 에러 발생");
			return "Error";
		}
	}
	
	@RequestMapping("updateBoard.do")
	public String doUpdate( Board pvo, HttpSession session, Model model) { //show_content
		
		System.out.println(pvo); // 작성자의 정보가 들어있는지 확인
		
		try {
			
//			Member mvo= (Member) session.getAttribute("pvo");
//			pvo.setMemberVO(mvo);
			boardService.updateBoard(pvo);
			
			//mvo가 들어가서 session에서 받아오는 것이 없어도 됨
			Board board = boardService.showContent(pvo.getNo());
			System.out.println(board);
			
			model.addAttribute("bvo", board);
			
			return "board/show_content";
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
			model.addAttribute("message", "Board - 게시글 수정중 에러 발생");
			return "Error";
		}
	}
	
	
}
