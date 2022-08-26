package app;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test07 {
	public static void main(String[] args) {
		// 집계함수에 대한 결과 조회 
		// - sum, avh, max, min, count
		// - 결과는 ResultSet이지만 데이터가 하나밖에 없다. 
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql ="select count(*) from music";
		
		int count = template.queryForObject(sql, int.class);
		System.out.println("count: " + count);
	}
}
