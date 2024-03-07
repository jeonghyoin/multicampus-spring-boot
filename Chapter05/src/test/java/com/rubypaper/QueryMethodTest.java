package com.rubypaper;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.domain.Board;
import com.rubypaper.domain.QBoard;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.BoardRepositoryQueryDSL;

@SpringBootTest
public class QueryMethodTest {

	// BoardRepository 인터페이스를 구현한 객체를 의존성 주입
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardRepositoryQueryDSL queryDSL;

	@Test
	public void testDynamicQuery() {
		
		// Dynamic 쿼리를 생성하기 위함
		BooleanBuilder builder = new BooleanBuilder();
		String condition = "TITLE";
		String keyword = "10";
		QBoard qboard = QBoard.board;
		if(condition.equals("TITLE")) { // 사용자가 제목 검색을 원하는 경우
			builder.and(qboard.title.like("%" + keyword + "%"));
		}
		
		Iterable<Board> boardList = queryDSL.findAll(builder);
		
		for(Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	// @Test
	public void testQueryAnnotation() {
		List<Object[]> boardList = boardRepository.getBoardList("게시글");

		for(Object[] board : boardList) {
			System.out.println("---> " + Arrays.toString(board));
		}
	}

	// 글 등록
	// @Test
	public void testQueryMethod() {
		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		Page<Board> pageInfo = boardRepository.findByTitleContaining("게시글", pageable);

		for(Board board : pageInfo) {
			System.out.println("---> " + board.toString());
		}
		
		if(pageInfo.hasPrevious()) {
			System.out.println("이전 페이지 있음 : " + pageInfo.previousPageable());
		}
		if(pageInfo.hasNext()) {
			System.out.println("다음 페이지 있음 : " + pageInfo.nextPageable());
		}
	}
	
	// @BeforeEach
	public void dataInit() {
		for(int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목 " + i);
			board.setContent("테스트 내용 " + i);
			// board.setWriter("작성자");
			
			boardRepository.save(board);
		}
	}
}
