package com.kh.spring18.service;

import com.kh.spring18.entity.CertDto;

public interface EmailService {
	void sendCertMail(String email);
	boolean checkCert(CertDto certDto);
}