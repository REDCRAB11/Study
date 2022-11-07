package com.kh.spring16;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.entity.MusicDto;

@SpringBootTest
public class MusicListTest {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		List<MusicDto> list = sqlSession.selectList("music.list");
		System.out.println(list.size());
	}
}
