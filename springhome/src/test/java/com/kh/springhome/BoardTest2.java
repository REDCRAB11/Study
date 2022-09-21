package com.kh.springhome;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.springhome.repository.BoardDao;

@SpringBootTest
public class BoardTest2 {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		//번호 생성
		String sql = "select board_seq.nextval from dual";
		int boardNo = jdbcTemplate.queryForObject(sql, int.class);
		System.out.println("boardNo = " + boardNo);
		
		//등록
		sql = "insert into board("
				+ "board_no, board_title, board_content,"
				+ "board_writer, board_head) "
				+ "values(?, ?, ?, ?, ?)";
		Object[] param = {
				boardNo, "테스트", "테스트", "hello1234", null
		};
		jdbcTemplate.update(sql, param);
	}

}



