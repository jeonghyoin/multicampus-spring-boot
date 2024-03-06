package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter01Application {

	public static void main(String[] args) {
		// Web application
		SpringApplication.run(Chapter01Application.class, args);
		
		// Java application
		// Java 설정보다 properties 설정이 우선
		// SpringApplication application = new SpringApplication(Chapter01Application.class);
		// application.setWebApplicationType(WebApplicationType.NONE); // Web Application이 아님을 명시(Tomcat 구동X)
		// application.run(args);
	}

}
