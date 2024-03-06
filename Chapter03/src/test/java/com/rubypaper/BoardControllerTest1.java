package com.rubypaper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.rubypaper.domain.BoardVO;

// 정상적으로 Tomcat 서버를 구동하고 테스트 (모든 객체를 생성)
// RANDOM_PORT: 랜덤한 포트를 할당하여 Tomcat 서버를 구동한다.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BoardControllerTest1 {
	
	// 가짜 웹 브라우저를 모킹
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception {
		String result = restTemplate.getForObject("/hello?name=TESTER", String.class);
		assertEquals("hello : TESTER", result.toString());
	}
	
	@Test
	public void testGetBoard() throws Exception {
		BoardVO result = restTemplate.getForObject("/getBoard", BoardVO.class);
		
		assertNotNull(result);
	}
	
	@Test
	public void testGetBoardList() throws Exception {
		List<BoardVO> result = restTemplate.getForObject("/getBoardList", List.class);
		
		assertEquals(5, result.size());
	}
}
