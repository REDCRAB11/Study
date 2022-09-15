package com.kh.spring12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {

	//테스트 메소드는 반드시 void 반환형을 가지고 매개변수는 없다. 
	@Test
	public void basic01(){
		// 목표:  1.1 + 2.2 는 3.3일 것이다! 
		double a = 1.1;
		double b = 2.2;
		double c = a+b;
		double d = 3.3;
		System.out.println(c == d); // 이렇게 출력하면 검증이 불가능
		
		// 단정문(Assertion) - test에서만 가능 
		assertEquals(c, d); // c와 d가 equals여야 성공
		assertNotEquals(c, d);
		
		
		
		
	}
	
	
	
}
