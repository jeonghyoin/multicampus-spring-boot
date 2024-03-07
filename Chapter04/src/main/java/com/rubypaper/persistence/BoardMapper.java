package com.rubypaper.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rubypaper.domain.Board;

// BoardMapper 인터페이스를 구현하는 객체를 Mybatis가 자동으로 생성
// 인터페이스만 정의하고, 나머지는 프레임워크에서 생성
// @Mapper
public interface BoardMapper {
	
	@Insert("INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT)"
			+ " VALUES((SELECT MAX(SEQ) + 1 FROM BOARD), #{title}, #{writer}, #{content})")
	public void insertBoard(Board board);
	
	@Select("SELECT * FROM BOARD ORDER BY SEQ DESC")
	public List<Board> getBoardList();
}
