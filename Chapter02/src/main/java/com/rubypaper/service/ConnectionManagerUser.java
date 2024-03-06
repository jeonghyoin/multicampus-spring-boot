package com.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.jdbc.ConnectionManager;

// ApplicationRunner를 구현한 객체가 메모리에 생성되면
// 무조건 run 메소드가 실행된다.
@Service
public class ConnectionManagerUser implements ApplicationRunner {
	
	@Autowired
	private ConnectionManager manager;
	
	public ConnectionManagerUser() {
		System.out.println("===> ConnectionManagerUser 생성");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// ConnectionManager(driverClass=org.h2.Driver, url=jdbc:h2:tcp://localhost/~/test, username=sa, password=)
		System.out.println(manager.toString());
	}

}
