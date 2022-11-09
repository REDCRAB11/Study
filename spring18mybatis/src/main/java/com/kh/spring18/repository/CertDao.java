package com.kh.spring18.repository;

import com.kh.spring18.entity.CertDto;

public interface CertDao {
	void insert(CertDto certDto);
	boolean check(CertDto certDto);
	boolean delete(String who);
}