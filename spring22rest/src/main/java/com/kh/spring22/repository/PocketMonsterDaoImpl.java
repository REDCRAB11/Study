package com.kh.spring22.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring22.entity.PocketMonsterDto;

@Repository
public class PocketMonsterDaoImpl implements PocketMonsterDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<PocketMonsterDto> list() {
		return sqlSession.selectList("pocketmon.list");
	}
	
	@Override
	public void insert(PocketMonsterDto dto) {
		sqlSession.insert("pocketmon.insert", dto);
	}
	
	@Override
	public boolean edit(PocketMonsterDto dto) {
		int count = sqlSession.update("pocketmon.edit", dto);
		return count > 0;
	}
	
	@Override
	public boolean delete(int no) {
		int count = sqlSession.delete("pocketmon.delete", no);
		return count > 0;
	}
	
	@Override
	public PocketMonsterDto find(int no) {
		return sqlSession.selectOne("pocketmon.get", no);
	}
}

