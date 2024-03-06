package com.rubypaper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rubypaper.junit.MyCalc;

class MyCalcTest {

	private MyCalc calc;

	/*
	 * // 테스트 메소드 앞에서 실행
	 * 
	 * @BeforeAll static void setUpBeforeClass() throws Exception {
	 * System.out.println("---> setUpBeforeClass"); }
	 * 
	 * // 테스트 메소드 뒤에서 실행
	 * 
	 * @AfterAll static void tearDownAfterClass() throws Exception {
	 * System.out.println("---> tearDownAfterClass"); }
	 */
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("---> setUp");
		calc = new MyCalc(10, 3);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("---> tearDown");
		calc = null;
	}

	@Test
	void testPlus() {
		System.out.println("---> testPlus");
		// fail("Not yet implemented");
		assertEquals(13, calc.plus());
	}

	@Test
	void testMinus() {
		System.out.println("---> testMinus");
		// fail("Not yet implemented");
		assertEquals(7, calc.minus());
	}

}
