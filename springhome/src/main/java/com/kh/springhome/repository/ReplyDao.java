package com.kh.springhome.repository;

import com.kh.springhome.entity.ReplyDto;

public interface ReplyDao {
	void insert(ReplyDto replyDto);
	
	boolean update(ReplyDto replyDto);
	ReplyDto selectOne(int replyN);
}
