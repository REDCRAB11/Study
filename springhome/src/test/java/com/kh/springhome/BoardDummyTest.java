package com.kh.springhome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.repository.BoardDao;

@SpringBootTest
public class BoardDummyTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void before() {
		for(int i=1; i <= 7905; i++) {
			boardDao.insert(BoardDto.builder()
									.boardHead(null)
									.boardTitle("저스라잌주"+i)
									.boardContent("광야야야"+i)
									.boardWriter("qwer1234")
								.build());
		}
	}
	
	@BeforeEach
	public void after() {
		boardDao.clear();
	}
	
}