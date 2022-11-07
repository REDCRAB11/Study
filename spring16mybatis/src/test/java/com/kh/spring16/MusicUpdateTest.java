package com.kh.spring16;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.entity.MusicDto;

@SpringBootTest
public class MusicUpdateTest {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		int count = sqlSession.update("music.edit", MusicDto.builder()
																											.musicNo(161)
																											.musicTitle("윤슬")
																											.musicArtist("NCT")
																											.musicAlbum("질주(2babies)")
																											.releaseTime(Date.valueOf("2022-10-08"))
																											.build());
		System.out.println("c" + count);
	}
}
