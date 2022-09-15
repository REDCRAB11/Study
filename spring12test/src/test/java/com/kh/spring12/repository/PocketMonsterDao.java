package com.kh.spring12.repository;

import com.kh.spring12.entity.PocketMonsterDto;

public interface PocketMonsterDao {
	void insert(int no, String name, String type);
	void insert(PocketMonsterDto pocketMonsterDto);
}
