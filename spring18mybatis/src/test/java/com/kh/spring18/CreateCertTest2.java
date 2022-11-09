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

@SpringBootTest
public class CreateCertTest2 {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private RandomGenerator randomGenerator;
	
	@Autowired
	private CertDao certDao;
	
	String email = "jaemini4ever@gmail.com";//사용자가 입력할 정보
	
	@Test
	public void test() {
		//목표 : (1) 랜덤인증번호생성 -> (2) 이메일발송 -> (3) 데이터베이스 등록
		
		//(1)
		String serial = randomGenerator.generateSerial(6);
		
		//(2)
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[나나드림] 이메일 인증번호입니다");
		message.setText("인증번호 : " + serial);
		javaMailSender.send(message);
		
		//(3)
		certDao.delete(email);
		CertDto certDto = CertDto.builder().who(email).serial(serial).build();
		certDao.insert(certDto);
	}
	
}
