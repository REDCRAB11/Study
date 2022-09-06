package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.GuestBookDto;

public interface GuestBookDao {
	void insert(GuestBookDto dto);
	List<GuestBookDto> selectList();
	List<GuestBookDto>selectList(String type, String keyword);
	
}
