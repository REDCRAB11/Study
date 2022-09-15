package com.kh.spring12.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring12.entity.PocketMonsterDto;

@Repository
public class PocketMonsterDaoImpl implements PocketMonsterDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(int no, String name, String type) {
		String sql = "insert into pocket_monster(no, name, type) values(?,?,?)";
		Object[] param = {no, name, type};
		jdbcTemplate.update(sql, param);
		
	}

	@Override
	public void insert(PocketMonsterDto pocketMonsterDto) {
		this.insert(pocketMonsterDto.getNo(), pocketMonsterDto.getName(), pocketMonsterDto.getType());
	}
}
