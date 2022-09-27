package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.AttachmentDto;

public interface AttachmentDao {
	int sequence();
	void insert(AttachmentDto attachmentDto);
	List<AttachmentDto> selectList();
	AttachmentDto selectOne(int attachmentNo);
	boolean delete(int attachmentNo);
	// 게시판 첨부파일 관련- board_attachment_view 조회하는 거임 ! 
	List<AttachmentDto> selectBoardAttachmentList(int boardNo);
}