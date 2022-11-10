package com.kh.spring19;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

//lombok에서 클래스에 @Slf4j 어노테이션 사용시 해당 클래스의 Logger 생성 
@Slf4j
@SpringBootTest
public class LoggingTest3 {
	
	@Test
	public void test() {
		log.debug("hel logging");
		
		//Logger의 좋은 점 
		int a = 10; 
		int b = 10;
		System.out.println(a + " + " + b + " =" + (a+b));
		log.debug("{} + {} = {}", a, b, a+b);
		
		try {
			int c = 10/0; //100% error
		}
		catch(Exception e) {
//			System.err.println("error");
//			e.printStackTrace();
			log.error("error", e);
		}
	}
}
