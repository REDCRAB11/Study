package com.kh.spring21.repository;

import com.kh.spring21.entity.SecomDto;

public interface SecomDao {
	void join(SecomDto secomDto);
	boolean login(SecomDto secomDto);
	SecomDto find(String id);
}
