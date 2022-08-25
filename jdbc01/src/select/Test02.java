package select;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test02 {
	public static void main(String[] args) {
		// 조회(Select)
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "select * from fifa";
		
		int result = template.update(sql);
		
		System.out.println("result: " + result);
		System.out.println("완료");
		
	}
}
