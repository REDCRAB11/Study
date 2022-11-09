package com.kh.spring18;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring18.entity.CertDto;
import com.kh.spring18.repository.CertDao;

@SpringBootTest
public class CheckCertTest2 {
	
	@Autowired
	private CertDao certDao;
	
	String email = "jaemini4ever@gmail.com";
	String serial = "433874";
	
	@Test
	public void test() {
		CertDto certDto = CertDto.builder()
												.who(email)
												.serial(serial)
											.build();
		boolean result = certDao.check(certDto);
		if(result) {//인증 성공
			System.out.println("인증 성공");
			certDao.delete(email);
		}
		else {
			System.out.println("인증 실패");
		}
	}
	
}
