package com.rubypaper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
// application.properties 파일에서 프로퍼티 정보를 추출
@ConfigurationProperties(prefix = "board.jdbc")
public class ConnectionManagerProperties {
	
	private String driverClass;
	private String url;
	private String username;
	private String password;

	public ConnectionManagerProperties() {
		System.out.println("===> ConnectionManagerProperties 실행");
	}
}
