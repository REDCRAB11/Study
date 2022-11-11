package com.kh.spring22.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring22.entity.MusicDto;
@Repository
public class MusicDaoImpl implements MusicDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MusicDto> list() {
		return sqlSession.selectList("music.list");
	}
	
	@Override
	public void insert(MusicDto dto) {
		sqlSession.insert("music.insert", dto);
	}
	
	@Override
	public boolean edit(MusicDto dto) {
		int count = sqlSession.update("music.edit", dto);
		return count > 0;
	}
	
	@Override
	public boolean delete(int musicNo) {
		int count = sqlSession.delete("music.delete", musicNo);
		return count > 0;
	}
	
	@Override
	public MusicDto find(int musicNo) {
		return sqlSession.selectOne("music.get", musicNo);
	}
}
