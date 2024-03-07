package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	// 쿼리 메소드 추가
	// SELECT b FROM Board b WHERE b.title = ?
	List<Board> findBoardByTitle(String searchKeyword);
	
	// 검색 키워드(searchKeyword)를 포함한 타이틀 검색
	// SELECT b FROM Board b WHERE b.title LIKE '%'||?||'%'
	List<Board> findByTitleContaining(String searchKeyword);

	// OR 조건 추가
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	// 내림차순 정렬
	List<Board> findByTitleContainingOrderBySeqDesc(String title);
	
	// 페이징 처리
	Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
	
	// %?1%: 위치 기반 param, :keyword: 이름기반 param
//	@Query("SELECT b FROM Board b WHERE b.title LIKE %:keyword% ORDER BY b.seq DESC")
//	List<Board> getBoardList(@Param("keyword") String searchKeyword);
	
//	@Query("SELECT b.seq, b.title, b.content FROM Board b WHERE b.title LIKE %:keyword% ORDER BY b.seq DESC")
//	List<Object[]> getBoardList(@Param("keyword") String searchKeyword);
	
	// 일반 SQL 사용 (jpql X)
	@Query(value = "SELECT seq, title, content FROM board WHERE title LIKE '%'||:keyword||'%' ORDER BY seq DESC",
		   nativeQuery = true)
	List<Object[]> getBoardList(@Param("keyword") String searchKeyword);
	
}
