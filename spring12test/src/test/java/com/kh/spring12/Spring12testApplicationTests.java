package com.kh.spring12;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 이 표시를 하면 프로젝트 내의 등록된 spring 도구를 사용할 수 있다. 
@SpringBootTest 
class Spring12testApplicationTests {

	@Test // 이 표시가 붙은 메소드는 테스트용 메소드.
	void contextLoads() {
		System.out.println("Test code");
	}

}
