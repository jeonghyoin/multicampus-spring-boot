package com.rubypaper.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	private static String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES((SELECT MAX(SEQ) + 1 FROM BOARD), ?, ?, ?)";
	private static String BOARD_LIST   = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	
	@Autowired
	private JdbcTemplate springJdbc;
	
	public void insertBoard(Map<String, Object> board) {
		springJdbc.update(BOARD_INSERT, board.get("TITLE"), board.get("WRITER"), board.get("CONTENT"));
	}
	
	public List<Map<String, Object>> getBoardList() {
		return springJdbc.queryForList(BOARD_LIST);
	}

}
