package insert;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test06 {
	public static void main(String[] args) {
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "";
		Object[] param = {};
		
		template.update(sql,param);
		System.out.println("완료!");
		
	}
}
