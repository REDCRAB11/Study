package com.kh.spring10.repository;

import java.util.List;

import com.kh.spring10.entity.BookDto;

public interface BookDao {
	
	void insert(BookDto dto);
	boolean update(BookDto dto);
	boolean delete(int serial);
	List<BookDto> selectList();
	List<BookDto>selectList(String genre, String keyword);
	BookDto selecOne(int serial);
}


