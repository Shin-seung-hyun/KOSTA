package com.web.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.dto.BoardReq;
import com.web.spring.dto.BoardRes;
import com.web.spring.entity.Board;
import com.web.spring.exception.BoardSearchNotException;
import com.web.spring.exception.DMLException;
import com.web.spring.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	final BoardRepository boardRepository;
	
	//addBoard()
	@Transactional
	public Board addBoard(BoardReq boardReq) {
		System.out.println("BoardReq ==>" + boardReq);
		
		Board board = boardReq.toBoard(boardReq); // DTO -- Entity로 변경
		System.out.println("toBoard ==>" + board);
		
		//save 하고나서 다시 Entity 반환한다.
		return boardRepository.save(board);
	}
	
	//findBoard(Long id)
	/*
	 * 하나의 게시글 못 찾으면 예외 처리
	 * 찾으면 Board 바로 전환
	 * 최종적으로 리턴하기 전에 BoardRes Collection으로 변환해서 반환
	 *  
	 *  하나 받을 때만 orElseThrow를 쓸 수 있다.
	 */
//	@Transactional(readOnly = true)
//	public Board findBoard(Long id) throws BoardSearchNotException {
//		return boardRepository.findById(id)
//							  .orElseThrow( () -> new BoardSearchNotException("게시글 번호를 확인하세요", " Not Found BoardSerch Not"));
//		
//	}
	
	@Transactional(readOnly = true)
	public BoardRes findBoard(Long id) throws BoardSearchNotException {
		Board board= boardRepository.findById(id)
				  .orElseThrow( () -> new BoardSearchNotException("게시글 번호를 확인하세요", " Not Found BoardSerch Not"));
							  
		return new BoardRes(board);
	}
	
	
	//getBoard(String memberId)
	/*
	 * 특정 회원이 작성한 게시글 못 찾으면 예외 처리
	 * 찾으면 List<Board> 바로 전환
	 * 최종적으로 리턴하기 전에 BoardRes Collection으로 변환해서 반환
	 * 
	 * 
	 * 람다형식으로 반환
	 * 여러개 받을 땐 orElseThrow를 쓸 수 없다.
	 *  
	 */
	@Transactional(readOnly = true)
	public List<BoardRes> getBoard(String memeberId) throws BoardSearchNotException{
		
		List<Board> list= boardRepository.getBoard(memeberId);
		
		if( list== null || list.isEmpty() )
			throw new BoardSearchNotException("특정 회원이 작성한 글 없습니다.", " Not Found BoardAll !!");
		
		return list.stream().map(BoardRes::new).collect(Collectors.toList());
	}
	
	
	//findAll ... 성능 상 안 좋다. boardList를 쓰자 + 작성한 사람도 포함해서 가져오기
	@Transactional(readOnly = true)
	public List<BoardRes> boardList() throws BoardSearchNotException{
		List<Board> list = boardRepository.boardList();
		
		if( list== null || list.isEmpty() )
			throw new BoardSearchNotException("전체 게시글이 없습니다.", " Not Found BoardAll !!");
		
		return list.stream().map(BoardRes::new).collect(Collectors.toList());
	}
	
	
	//updateBoard(Long id, BoardReq board) ... 하나의 게시물 받아와서 필드 변경 entity와 snapshot이 달라져서 update가 됨
//	@Transactional
//	public Board updateBoard(Long id, BoardReq board) throws DMLException{
//		Board boardEntity = boardRepository.findById(id)
//										.orElseThrow(()-> new DMLException("글 번호 오류로 수정에 실패했습니다.", "Not Update"));
//		
//		boardEntity.setTitle(board.getTitle());
//		boardEntity.setContent(board.getContent());
//		
//		return boardEntity;
//	}
	
	@Transactional
	public BoardRes updateBoard(Long id, BoardReq board) throws DMLException{
		Board boardEntity = boardRepository.findById(id)
							.orElseThrow(()->new DMLException("글번호 오류로 수정에 실패", "Not Update~~!"));	
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		
		return new BoardRes(boardEntity);
	}
	
	
	//delteBoard(Long id)
	@Transactional
	public String deleteBoard(Long id) {
		Board boardEntity = boardRepository.findById(id)
								.orElseThrow(()-> new DMLException("글 번호 오류로 삭제에 실패했습니다.", "Not Delete", HttpStatus.BAD_REQUEST));
		
		boardRepository.delete(boardEntity);

		return "OK";
	}
	
}
