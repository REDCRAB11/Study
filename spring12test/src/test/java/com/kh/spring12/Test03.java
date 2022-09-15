package com.kh.spring12;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.repository.PocketMonsterDao;

@SpringBootTest
public class Test03 {
	
	@Autowired
	private PocketMonsterDao pocketMonsterDao;
	
	@Test
	public void test01() {
		assertNotNull(pocketMonsterDao);
	}
	
	@Test
	public void test02() {
		pocketMonsterDao.insert(60,"발챙이", "물");
	}
}
