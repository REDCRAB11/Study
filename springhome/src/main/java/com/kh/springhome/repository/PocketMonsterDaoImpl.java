package com.kh.springhome.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.PocketMonsterDto;

@Repository
public class PocketMonsterDaoImpl implements PocketMonsterDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
}

