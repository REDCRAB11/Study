package com.kh.spring19;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggingTest1 {

	//Spring에서는 Log4J든 Logback이든 직접적으로 사용하지 않는다. 
	// - 어댑터 라이브러리로 SLF4J라는 것을 사용한다. 
	
	private Logger log = LoggerFactory.getLogger(LoggingTest1.class);
	
	/*
	  로깅 메세지 수준(level)
	  - 메세지의 수준을 구분하여 용도에 맞게 상황에 맞게 사용하는 것을 목표 
	  - TRACE -> DEBUG -> INFO -> WARN -> ERROR -> FATAL
	 - TRACE: 추적을 위해 작성하는 상세 메세지 
	 - DEBUG: 문제 해결을 위해 작성하는 개발용 메세지  
	 - INFO: 사용자에게 정보를 알려주기 위해 작성하는 메세지 
	 - WARN: 사용자에게 경고를 하기 위한 메세지 
	 - ERROR: 사용자에게 오류를 알려주기 위한 메세지 
	 -FATAL: 프로그램이 중단되는 치명적인 문제를 알려주는 메세지 
	  */
	@Test
	public void test() {
		log.trace("trace 메세지");
		log.debug("debug 메세지");
		log.info("info 메세지");
		log.warn("warn메세지");
		log.error("error 메세지");
	}
}
