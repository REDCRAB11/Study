package com.kh.spring12;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test08 {
	@Test
	public void test() {
		//일반 생성
		Student s = new Student();
		s.setName("피카츄");
		s.setScore(50);
		//System.out.println(s.getName()+" / " + s.getScore());
		System.out.println(s);
		
		//Builder 생성
		Student a = Student.builder().name("피카츄").score(50).build();
		System.out.println(a);
	}
}




