package com.rubypaper;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

	// BoardRepository 인터페이스를 구현한 객체를 의존성 주입
	@Autowired
	private BoardRepository boardRepository;

	// 글 등록
	@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("두번째 게시글 테스트");
		board.setContent("게시글 내용");
		// board.setWriter("작성자");

		boardRepository.save(board);
	}

	// 글 상세조회
	// @Test
	public void testGetBoard() {
		Optional<Board> findBoard = boardRepository.findById(1);

		if (findBoard.isPresent()) {
			Board board = findBoard.get();
			System.out.println("검색 결과 : " + board.toString());
		}
	}

	// 글 수정
	// @Test
	public void testUpdateBoard() {
		Board board = new Board();
		board.setSeq(1); // 식별자 세팅이 되어있으면 update
		board.setTitle("--게시글 수정--");
		board.setContent("--게시글 내용 수정--");

		// insert, update ==> save
		boardRepository.save(board);
	}

	// 글 삭제
	// @Test
	public void testDeleteBoard() {
		// select(managed 상태로 만든다) -> delete
		boardRepository.deleteById(1);
	}
}
