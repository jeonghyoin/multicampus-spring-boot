package com.rubypaper;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.User;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class RelationMappingTest {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	// 양방향 매핑
	@Test
	@Transactional
	public void testManyToOneBoth() {
		
		User user = userRepository.findById("user01").get();
		
		List<Board> boardList = user.getBoardList();
		for(Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	// 연관 매핑
	// @Test
	@Transactional
	public void testManyToOne() {
		Board board = boardRepository.findById(5).get();
		System.out.println("[" + board.getSeq() + "번 게시글 정보]");
		System.out.println(board.toString());
	}

	// @BeforeEach
	public void dataInit() {
		// 회원 생성
		User user1 = new User();
		user1.setId("user01");
		user1.setName("둘리");
		userRepository.save(user1);
		
		User user2 = new User();
		user2.setId("user02");
		user2.setName("도우너");
		userRepository.save(user2);
		
		// 게시글 생성
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("둘리가 등록한 게시글 " + i);
			board.setContent("둘리가 등록한 게시글 " + i);
			board.setUser(user1); // users의 기본키 - 미지정 시 null 세팅
			boardRepository.save(board);
		}

		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("도우너가 등록한 게시글 " + i);
			board.setContent("도우너가 등록한 게시글 " + i);
			board.setUser(user2); // users의 기본키
			boardRepository.save(board);
		}
	}
}
