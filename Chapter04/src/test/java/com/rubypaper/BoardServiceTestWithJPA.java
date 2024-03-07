package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@SpringBootTest
public class BoardServiceTestWithJPA {

	// 목록 검색
//	@Test
//	public void getBoardListTest() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		
//		// 글 등록
//		for(int i = 1; i <= 10; i++) {
//			Board board = new Board();
//			board.setTitle(i + "번 게시글");
//			board.setWriter(i + "번 작성자");
//			board.setContent(i + "번 게시글 내용");
//			board.setRegDate(new Date());
//			board.setCnt(0);
//			em.persist(board);
//		}	
//		tx.commit();
//		
//		// 목록 조회
//		// Board는 테이블이 아니라 Entity명(클래스와 변수명은 대소문자를 구분)
//		String jpql = "SELECT b FROM Board b ORDER BY b.seq DESC";
//		List<Board> boardList = em.createQuery(jpql).getResultList();
//		for(Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//		
//		em.close();
//		emf.close();
//	}

	// 글 삭제
//	@Test
//	public void getBoardTest() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//
//		Board findBoard = em.find(Board.class, 1);
//		System.out.println("검색 결과 ===> " + findBoard.toString());
//
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//
//		// 글 삭제 em.remove(findBoard); tx.commit();
//
//		em.close();
//		emf.close();
//	}

	// 글 상세조회
	@Test
	public void getBoardTest() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();

		Board findBoard = em.find(Board.class, 1);
		System.out.println("findBoard 상태(before) : " + em.contains(findBoard)); // true(영속 상태)
		System.out.println("검색 결과 ===> " + findBoard.toString());

		em.detach(findBoard);
		System.out.println("findBoard 상태(after) : " + em.contains(findBoard)); // false(detach 후 준영속 상태)

		// 등록, 수정, 삭제는 트랜젝션 안에서 이루어져야 한다. // 없을 경우 실행되지 않음
		findBoard.setTitle("--제목 수정(!)--");
		// findBoard.setContent("--내용 수정--");

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Board newBoard = em.merge(findBoard);
		System.out.println("merge 이후 findBoard : " + em.contains(findBoard)); // false
		System.out.println("merge 이후 newBoard : " + em.contains(newBoard)); // true
		tx.commit();

		em.close();
		emf.close();
	}

	// 글 등록
//	@Test
//	public void insertBoardTest() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//
//		EntityTransaction tx = em.getTransaction();
//		tx.begin(); // Transaction 시작
//
//		Board board = new Board();
//		board.setTitle("JPA 테스트");
//		board.setWriter("JPA");
//		board.setContent("JPA 테스트 중입니다.");
//		board.setRegDate(new Date());
//		board.setCnt(0);
//		
//		em.persist(board); // 1차 캐시에 등록만 할 뿐 실제 insert는 실행되지 않음
//		System.out.println("---> 글 등록 성공"); // persis -> commit 후 insert 실행
//		tx.commit(); // Transaction 종료
//
//		em.close();
//		emf.close();
//	}

}
