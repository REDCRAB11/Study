package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.PocketMonsterDto;

public interface PocketMonsterDao {

	void insert(PocketMonsterDto pocketMonsterDto);
	List<PocketMonsterDto> selectList();
	PocketMonsterDto selectOne(int no);
}
