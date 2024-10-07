package com.service.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write.do")
	public String write( Board bvo , HttpSession session, Model model) {
		
		try {
			Member mvo = (Member) session.getAttribute("mvo");
			
			if(mvo ==null) return "redirect:index.jsp";
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

}
