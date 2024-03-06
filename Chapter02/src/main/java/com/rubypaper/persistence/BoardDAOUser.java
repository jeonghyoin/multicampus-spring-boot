package com.rubypaper.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.persistence.BoardDAO;

//ApplicationRunner를 구현한 객체가 메모리에 생성되면 무조건 run 메소드가 실행된다.
@Service
public class BoardDAOUser implements ApplicationRunner {
	@Autowired
	private BoardDAO dao;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Map<String, Object> board = new HashMap<String, Object>();
		board.put("TITLE", "글 등록");
		board.put("WRITER", "테스터");
		board.put("CONTENT", "글 내용");

		dao.insertBoard(board);

		List<Map<String, Object>> list = dao.getBoardList();
		for (Map<String, Object> row : list) {
			System.out.println("--->" + row.toString());
		}
	}
}
