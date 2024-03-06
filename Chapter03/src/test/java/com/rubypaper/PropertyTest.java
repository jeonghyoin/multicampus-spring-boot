package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.rubypaper.Controller.BoardController;

// @SpringBootApplication과 동일
@SpringBootTest(properties = {"author.name=Gurum",
							  "author.age=49",
							  "author.nation=Korea"},
				classes = {BoardController.class})
public class PropertyTest {
	
//	@Value("${author.name}")
//	private String name;
//	
//	@Value("${author.age}")
//	private int age;
	
	@Autowired
	private Environment env;
	
	@Test
	public void testMethod() {
		// assertTrue(true);
		System.out.println("이름 : " + env.getProperty("author.name"));
		System.out.println("나이 : " + env.getProperty("author.age"));
		System.out.println("국가 : " + env.getProperty("author.nation"));
	}
}
