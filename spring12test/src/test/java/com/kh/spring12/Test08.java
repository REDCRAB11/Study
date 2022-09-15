package com.kh.spring12;

import org.junit.jupiter.api.Test;

public class Test08 {
	@Test
	public void test() {
		// 일반 생성
		Student s = new Student();
		s.setName("피카");
		s.setScore(50);
		System.out.println(s);
//		System.out.println(s.getName());
		System.out.println(s.getScore());
		
		// Builder 생성
		Student a = Student.builder().name("피카츄").score(50).build();
		System.out.println(a);
	}
}
