package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS") // 대부분의 DBMS에서 USER는 예약어
public class User {
	@Id 
	private String id;
	
	private String password;
	
	private String name;
	
	private String role;
	
	// mappedBy: 연관관계의 주인이 아님을 표시
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Board> boardList = new ArrayList<Board>();
}
