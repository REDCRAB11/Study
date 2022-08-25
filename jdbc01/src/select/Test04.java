package select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import util.JdbcUtil;

public class Test04 {
	public static void main(String[] args) {
//		 SELECT는 INSERT, UPDATE, SELETE와 같은 방법으로는 사용 불
//		(추가)
//		 - 테이블을 객체 형태로 변환해서 List로 추출해야 한다.  
//		 - 자바는 테이블의 한줄이 어떻게 객체에 추가되어야 하는지 모른다. 
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "select * from fifa";
	
		// 변경 방법이 작성된 객체를 구현 -RowMapper 클래스 사용 
//		RowMapper<Country> mapper = new RowMapper<Country>() {
//			public Country mapRow(ResultSet rs, int idx) throws SQLException {
				RowMapper<Country> mapper = (rs, idx) -> {
				Country c = new Country();
				c.setRank(rs.getInt("rank"));
				c.setState(rs.getString("state"));
				c.setScore(rs.getDouble("score"));
				return c;
				};
//			}
//		};
		
		List<Country> list = template.query(sql, mapper);
		for(Country c : list) {
//			System.out.println(c);
			System.out.println(c.getRank());
			System.out.println(c.getState());
			System.out.println(c.getScore());
		}
		
	}
}
