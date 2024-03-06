package com.rubypaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.ConnectionManager;

@Configuration
// ConnectionManagerProperties 클래스를 찾아서 객체 생성
@EnableConfigurationProperties(ConnectionManagerProperties.class)
public class BoardAutoConfiguration {
	
	@Autowired
	ConnectionManagerProperties properties;
	
	public BoardAutoConfiguration() {
		System.out.println("===> BoardAutoConfiguration 생성");
	}
	
	@Bean
	// @ConditionalOnMissingBean: ConnectionManager 타입의 객체가 메모리에 없다면 생성
	@ConditionalOnMissingBean
	ConnectionManager connectionManager() {
		ConnectionManager manager = new ConnectionManager();
		
		manager.setDriverClass(properties.getDriverClass());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		
		return manager;
	}
}
