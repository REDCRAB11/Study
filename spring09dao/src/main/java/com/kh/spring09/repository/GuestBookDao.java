package com.kh.spring09.repository;

import java.util.List;

import com.kh.spring09.entity.GuestBookDto;

// DAO(Data Access Object) : 목차(추상체)
public interface GuestBookDao {
//		둘 중 하나 써도 맞지만 굳이 쓴다면 dto를  
//	void insert(String name, String memo);
	void insert(GuestBookDto dto); // 등록 기능 
	boolean update(GuestBookDto dto); // 수정 기능
	boolean delete(int no); // 삭제 기능
	List<GuestBookDto> selectList(); // 목록 기능
	List<GuestBookDto> selectList(String type, String keyword); //검색 기능
	GuestBookDto selectOne(int no);//상세기능
}
