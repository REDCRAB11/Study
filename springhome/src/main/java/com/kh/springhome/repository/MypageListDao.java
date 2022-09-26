package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.MypageListDto;

public interface MypageListDao {
	
	MypageListDto selectOne(MypageListDto dto);
//	List<MypageListDto> selectLisct(MypageListDto dto);
}
