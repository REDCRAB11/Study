package com.kh.spring18;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.kh.spring18.entity.CertDto;

@SpringBootTest
public class CreateCertTest {
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private JavaMailSender javaMailSender;

	//사용자가 입력할 정보
	String email="jaemini4ever@gmail.com";
	
	@Test
	public void test() {
		//목표: (1)랜덤인증번호생성 -> (2)이메일발송 -> (3)데이터베이스 등록
		
		//(1)
		Random r = new Random();
		int number = r.nextInt(1000000);
		System.out.println("num" + number);
		
		Format f = new DecimalFormat("000000");
		String serial = f.format(number);
		
		//(2)
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[나나드림]이메일 인증번호 입니다.");
		message.setText("인증번호: " + serial);
		javaMailSender.send(message);
		
		//(3) 
		sqlSession.delete("cert.delete", email);
		CertDto certDto = CertDto.builder().who(email).serial(serial).build();
		sqlSession.insert("cert.insert", certDto);
	}
}