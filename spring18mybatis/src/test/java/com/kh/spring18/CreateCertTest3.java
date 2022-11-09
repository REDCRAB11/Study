package com.kh.spring18;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.kh.spring18.component.RandomGenerator;
import com.kh.spring18.entity.CertDto;
import com.kh.spring18.repository.CertDao;
import com.kh.spring18.service.EmailService;

@SpringBootTest
public class CreateCertTest3 {
	
	@Autowired
	private EmailService emailService;
	
	//사용자가 입력할 정보
	String email="jaemini4ever@gmail.com";
	
	@Test
	public void test() {
		emailService.sendCertMail(email);
	}
}