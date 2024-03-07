package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Data
@Entity
// DB에 무관하게 사용 가능
//@TableGenerator(name = "BOARD_SEQ_GENERATOR",
//				table = "SEQUENCE_TABLE",
//				pkColumnName = "BOARD_SEQ",
//				initialValue = 0,
//				allocationSize = 1)

// next value for BOARD_SEQUENCE => TableGenerator보다 빠르다
//@SequenceGenerator(name = "BOARD_SEQ_GENERATOR",
//				   sequenceName = "BOARD_SEQUENCE",
//				   initialValue = 1,
//				   allocationSize = 1)
public class Board {
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
	// JPA가 시퀀스를 생성 => create sequence Board_SEQ start with 1 increment by 50
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seq;

	@Column(nullable = false) // NOT NULL 제약조건 추가
	private String title;

	@Column(length = 50, nullable = false) // 글자수 제한
	private String writer;

	@Column(unique = true) // UNIQUE 제약조건 추가
	private String content;

	@Column(insertable = false, updatable = false)
	private Date regDate;

	@Column(insertable = false, updatable = false)
	private int cnt;
}
