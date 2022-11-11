package com.kh.spring21.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring21.entity.SecomDto;

@Repository
public class SecomDaoImpl implements SecomDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void join(SecomDto secomDto) {
		String pw = secomDto.getPw();
		String enc = encoder.encode(pw);
		secomDto.setPw(enc);
		sqlSession.insert("secom.join", secomDto);
	}
	@Override
	public boolean login(SecomDto secomDto) {
		SecomDto findDto = sqlSession.selectOne("secom.get", secomDto.getId());
		if(findDto == null) return false;
		boolean judge = encoder.matches(secomDto.getPw(), findDto.getPw());
		return judge;
	}
	@Override
	public SecomDto find(String id) {
		return sqlSession.selectOne("secom.get", id);
	}
	
}

