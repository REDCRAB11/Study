package com.kh.spring21;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SecurityTest3 {
	//단방향 암호화: 복구가 안되게 모자이크 느낌으로 변환하는 방법
	// - 크기를 키운 뒤 잘라내는 방식으로 처리 
	// - 무조건 1개의 값이 1개의 결과를 가져야 한다. 
	// - 2개 이상이 1개의 결과를 가지는 경우를 충돌이라고 한다. 
	// - 충돌이 발생한 암호화 알고리즘은 폐기 절차를 밟는다. 
		@Test
		public void test() {
			int value = 155;
			value *= 12345;
			value <<= 4;
	  		value %= 1000000;
	  		
	  		log.debug("value = {} ", value);
	}
}
