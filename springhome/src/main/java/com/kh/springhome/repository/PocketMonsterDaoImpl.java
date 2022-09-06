package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.PocketMonsterDto;

@Repository
public class PocketMonsterDaoImpl implements PocketMonsterDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<PocketMonsterDto> mapper = new RowMapper<PocketMonsterDto>() {
		@Override
		public PocketMonsterDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			PocketMonsterDto dto = new PocketMonsterDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setType(rs.getString("type"));
			return dto;
		}
	};

	@Override
	public void insert(PocketMonsterDto pocketMonsterDto) {
		String sql = "insert into pocket_monster(no, name, type) "
							+ "values(?, ?, ?)";
		Object[] param = {
				pocketMonsterDto.getNo(),
				pocketMonsterDto.getName(),
				pocketMonsterDto.getType()
		};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<PocketMonsterDto> selectList() {
		String sql = "select * from pocket_monster order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}
}

