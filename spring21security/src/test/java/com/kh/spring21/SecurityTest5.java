package com.kh.spring21;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring21.entity.SecomDto;
import com.kh.spring21.repository.SecomDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SecurityTest5 {

	@Autowired
	private SecomDao secomDao;
	
//	@Test
	public void join() {
		SecomDto secomDto = SecomDto.builder().id("test").pw("test").build();
		secomDao.join(secomDto);
	}
	
	@Test
	public void login() {
		SecomDto secomDto = SecomDto.builder().id("test").pw("test").build();
		boolean login = secomDao.login(secomDto);
		log.debug("login = {}", login);
		assertTrue(login);
	}
	
}
