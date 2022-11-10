package com.kh.spring19;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggingTest2 {
	private Logger log = LoggerFactory.getLogger(LoggingTest2.class);
	
	@Test
	public void test() {
		for(int i=0; i < 100000; i++) {
			log.debug("hello logging");
		}
	}
}
