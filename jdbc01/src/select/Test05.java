package select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import util.JdbcUtil;

public class Test05 {
	public static void main(String[] args) {
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "select * from guest_book order by no desc";

		RowMapper<GuestBookDto> mapper = new RowMapper<GuestBookDto>() {
			@Override
			public GuestBookDto mapRow(ResultSet rs, int idx) throws SQLException {
				GuestBookDto c =new GuestBookDto();
				c.setNo(rs.getInt("no"));
				c.setName(rs.getString("name"));
				c.setMemo(rs.getString("memo"));
				return c;
			}
		};
		List<GuestBookDto> list = template.query(sql, mapper);
		for(GuestBookDto c : list) {
			System.out.println(c);
		}
	}
}
