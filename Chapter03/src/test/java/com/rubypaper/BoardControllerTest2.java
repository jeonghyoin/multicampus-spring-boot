package com.rubypaper;

// static import
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rubypaper.Controller.BoardController;

// Controller 테스트를 위함(@Controller, @RestController만 메모리에 띄운다)
// 서블릿 컨테이너를 모킹하여 MockMvc 객체를 생성
@WebMvcTest
public class BoardControllerTest2 {
	
	// 모킹된 가짜 서블릿 컨테이너
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHello() throws Exception {
		// 가짜 서블릿 컨테이너에게 HTTP 요청 전송
//		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("name", "gurum"))
//		// HTTP 응답 결과 검증
//		.andExpect(MockMvcResultMatchers.status().isOk()) // is(200): 응답코드까지 검증
//		.andExpect(MockMvcResultMatchers.content().string("hello : gurum"));
		
		mockMvc.perform(get("/hello").param("name", "gurum")).andExpect(status().isOk()).andExpect(content().string("hello : gurum"));
	}
}
