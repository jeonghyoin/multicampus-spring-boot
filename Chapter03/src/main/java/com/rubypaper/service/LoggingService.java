package com.rubypaper.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingService implements ApplicationRunner {
	
	// 로그를 출력하기 위한 Logger 객체
	private Logger LOGGER = LoggerFactory.getLogger(LoggingService.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.trace("TRACE 레벨");
		LOGGER.debug("DEBUG 레벨");
		LOGGER.info("INFO 레벨");
		LOGGER.warn("WARN 레벨");
		LOGGER.error("ERROR 레벨");
	}

}
