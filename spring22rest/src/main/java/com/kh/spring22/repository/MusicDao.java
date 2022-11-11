package com.kh.spring22.repository;

import java.util.List;

import com.kh.spring22.entity.MusicDto;

public interface MusicDao {

	List<MusicDto> list();

	void insert(MusicDto dto);

	boolean edit(MusicDto dto);

	boolean delete(int no);
	
	MusicDto find(int no);
}
