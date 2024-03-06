package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

// 메인 클래스
// @ComponentScan -> @EnableAutoConfiguration 순으로 실행이 된다 (중요!)

// @SpringBootApplication (아래 3개 어노테이션 포함)
@SpringBootConfiguration

// Spring에서 제공하는 클래스를 메모리에 띄운다
// org.springframework.boot.autoconfigure.AutoConfiguration.imports
@EnableAutoConfiguration

// @ComponentScan 대상은 메모리에 뜬다(@Controller, @Service 등...)
@ComponentScan
public class Chapter02Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Chapter02Application.class, args);
	}

}
