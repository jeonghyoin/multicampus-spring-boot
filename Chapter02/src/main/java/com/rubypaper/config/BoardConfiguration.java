//package com.rubypaper.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.rubypaper.jdbc.ConnectionManager;
//import com.zaxxer.hikari.HikariDataSource;
//
//@Configuration
//public class BoardConfiguration {
//	
//	// BoardAutoConfiguration와 다름
//	public BoardConfiguration() {
//		System.out.println("===> BoardConfiguration 생성");
//	}
//	
//	// WebMvcAutoConfiguration(Spring에서 제공) 대신 커스터마이징: 우선순위가 더 높다
//	// ConnectionManager가 중복되면 오류 발생
//	// Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true
//	// @ComponentScan(@Configuration) -> @EnableAutoConfiguration 순으로 실행 -> h2가 먼저 메모리에 뜬 후 oracle이 덮어쓴다
//	// @ConditionalOnMissingBean을 설정해주어야한다.
//	/* @Bean
//	ConnectionManager connectionManager() {
//		ConnectionManager manager = new ConnectionManager();
//		manager.setDriverClass("org.h2.Driver");
//		manager.setUrl("jdbc:h2:tcp://localhost/~/test");
//		manager.setUsername("sa");
//		manager.setPassword("");
//		
//		return manager;
//	} */
//	
//	// Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "BOARD" not found (this database is empty); SQL statement:
//	@Bean
//	DataSource dataSource() {
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("");
//		
//		return dataSource;
//	}
//}
