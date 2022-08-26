package app;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test08 {
	public static void main(String[] args) {
		// .class는 모든 클래스에 자동으로 생기는 클래스 정보 객체 
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "select sum(music_play) from music";
		
		int sum = template.queryForObject(sql, int.class);
		System.out.println("sum: " + sum);
	}
}
