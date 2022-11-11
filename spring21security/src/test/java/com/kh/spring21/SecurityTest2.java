package com.kh.spring21;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SecurityTest2 {
		@Test
		public void test() {
			//xor 암호화: xor연산을 2번 하면 자기자신으로 돌아오는 특징 활용 
			
			char ch = 'a';
			int offset = 5;
			
			ch ^= offset;
			log.debug("ch = {}", ch);
			
			ch ^= offset;
			log.debug("ch = {}", ch);
		}
		
		
		@Test
		public void test2() {
			String origin = "GOTOHELL";
			int offset = 3;
			StringBuffer encrypt = new StringBuffer();
			for(int i=0; i<origin.length(); i++) {
				char ch = origin.charAt(i);
				ch ^= offset;
				encrypt.append(ch);
			}
			log.debug("encrypt = {} " , encrypt);
			
			StringBuffer decrypt = new StringBuffer();
			for(int i=0; i <encrypt.length(); i++) {
				char ch = encrypt.charAt(i);
				ch ^= offset;
				decrypt.append(ch);
				}
			log.debug("decrypt = {}", decrypt);
		}
}
