package com.rubypaper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rubypaper.Controller.BoardController;
import com.rubypaper.service.BoardService;

@SpringBootTest // 모든 종류의 객체를 생성
@AutoConfigureMockMvc // 서블릿 컨테이너를 모킹
public class BoardControllerTest3 {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BoardService service; // BoardService 타입의 객체를 모킹
	
	@Test
	public void testHello() throws Exception {
		// 가짜 BoardServiceImpl 객체의 hello 메소드 호출할 때 리턴값 설정
		when(service.hello("TESTER")).thenReturn("hello : TESTER");
		
		mockMvc.perform(get("/hello").param("name", "TESTER"))
		 .andExpect(status().isOk())
		 .andExpect(content().string("hello : TESTER"));
	}
	
	@Test
	public void testGetBoard() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("SEQ", 1);
		result.put("TITLE", "hi");
		result.put("WRITER", "tester");
		when(service.getBoard(1)).thenReturn(result);
		
		mockMvc.perform(get("/getBoard").param("seq", "1"))
		 .andExpect(status().is(200))
		 .andExpect(jsonPath("$.WRITER").isNotEmpty())
		 .andExpect(jsonPath("$.WRITER").value("tester"));
	}
}
