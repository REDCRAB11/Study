package com.kh.spring16;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.entity.MusicDto;

@SpringBootTest
public class MusicInsertTest {

		@Autowired
		private SqlSession sqlSession;
		
		@Test
		public void test() {
			MusicDto dto = MusicDto.builder()
															.musicTitle("윤슬")
															.musicArtist("NCT")
															.musicAlbum("질주")
															.releaseTime(Date.valueOf("2022-10-22"))
															.build();
			sqlSession.insert("music.insert", dto);
		}
}
