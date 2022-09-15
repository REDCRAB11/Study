package com.kh.spring12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootTest
public class Test02 {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void basic02() {
		int no = 56;
		String name = "팬텀";
		String type = "환영";
		
		String sql = "insert into pocket_monster(no, name, type) values(?,?,?)";
		Object[] param = {no, name, type};
		jdbcTemplate.update(sql, param);
	}
}
