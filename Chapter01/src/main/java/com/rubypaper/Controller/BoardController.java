package com.rubypaper.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

@RestController
public class BoardController {
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	// @RequestMapping(value="/hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	public String hello(String name) {
		return "hello : " + name;
	}
	
	@GetMapping("/getBoard")
	// @ResponseBody: 리턴되는 자바 객체를 JSON으로 변환하여 HTTP 응답 body에 출력 (RestController일 경우X)
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setWriter("작성자");
		board.setContent("내용");
		board.setTitle("제목");
		board.setRegDate(new Date());
		board.setCnt(0);
		
		return board;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for (int i=1; i<=5; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setWriter("작성자 " + i);
			board.setContent("내용 " + i);
			board.setTitle("제목 " + i);
			board.setRegDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		
		return boardList;
	}
}
