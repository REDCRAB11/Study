package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.BoardDto;

public interface BoardDao {

	void write(BoardDto boardDto);
	List<BoardDto> selectList();
	BoardDto selectOne(String boardWriter);
	BoardDto selectOne(int boardNo);
	boolean delete(String boardWriter);
	boolean update(BoardDto dto);
	List<BoardDto> selectList(String type, String keyword);
}
