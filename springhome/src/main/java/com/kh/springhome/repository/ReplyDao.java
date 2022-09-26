package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.ReplyDto;
import com.kh.springhome.vo.ReplyListVO;

public interface ReplyDao {
	void insert(ReplyDto replyDto);
	List<ReplyListVO> selectList(int replyOrigin);
	ReplyDto selectOne(int replyNo);
	boolean update(ReplyDto replyDto);
	boolean delete(int replyNo);
	boolean updateBlind(int replyNo, boolean blind);
}





