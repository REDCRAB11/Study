package select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.PocketMonsterDto;
import util.JdbcUtil;

public class Test07 {
	public static void main(String[] args) {
		// 검색
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "select * from pocket_monster where instr(name,?) >0 ";
		Object[] param = {"이상해"};
		RowMapper<PocketMonsterDto> mapper = (rs,idx)->{
			PocketMonsterDto dto = new PocketMonsterDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setType(rs.getString("type"));
			return dto;
		};
		List<PocketMonsterDto> list = template.query(sql, mapper, param);
		System.out.println("검색결과: " + list.size() + "개");
		for(PocketMonsterDto dto : list) {
			System.out.println(dto);
		}
		
	} 
}
