package com.rubypaper.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;

// @Service
public class BoardServiceWithMybatis implements ApplicationRunner {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Board board = new Board();
		board.setTitle("mybatis 제목");
		board.setWriter("mybatis 작성자");
		board.setContent("mybatis 내용");
		mybatis.insert("insertBoard", board);
		
		List<Board> boardList = mybatis.selectList("getBoardList");
		for(Board row : boardList) {
			System.out.println("--->" + row.toString());
		}
	}
}
