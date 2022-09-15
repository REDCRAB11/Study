package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.MusicDto;
import com.kh.springhome.vo.MusicYearCountVO;

public interface MusicDao {
	void insert(MusicDto dto);
	List<MusicDto> selectList();
	List<MusicDto> selectList(String type, String keyword);
	MusicDto selectOne(int musicNo);
	boolean update(MusicDto dto);
	boolean delete(int musicNo);
	
	List<MusicYearCountVO> selectCountList();
	
	List<MusicDto> top10();
	List<MusicDto> topN(int limit);
}
