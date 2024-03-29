package com.rubypaper.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.rubypaper.domain.Board;

public interface BoardRepositoryQueryDSL extends JpaRepository<Board, Integer>, ListQuerydslPredicateExecutor<Board> {
	
}
