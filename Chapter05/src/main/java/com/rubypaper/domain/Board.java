package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "user") // 순환참조 끊기
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq; // 1부터 자동으로 증가된 값이 할당

	private String title;

	// private String writer;

	private String content;

	private Date regDate = new Date();

	private int cnt = 0;
	
	// 참조변수 선언
	@ManyToOne(fetch = FetchType.EAGER) // 다대일 관계 설정, LAZY(권장)/EAGER(기본값)
	@JoinColumn(name = "USER_ID", nullable = false) // USER_ID를 FK로 설정, nullable 설정 시 외부->내부조인으로 조회
	private User user;
}
