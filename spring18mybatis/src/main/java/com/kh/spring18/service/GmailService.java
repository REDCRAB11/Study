package com.kh.spring18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kh.spring18.component.RandomGenerator;
import com.kh.spring18.entity.CertDto;
import com.kh.spring18.repository.CertDao;

@Service
public class GmailService implements EmailService {
	
	@Autowired
	private RandomGenerator randomGenerator;
	
	@Autowired
	private CertDao certDao;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendCertMail(String email) {
		//목표 : (1) 랜덤인증번호생성 -> (2) 이메일발송 -> (3) 데이터베이스 등록
		
		//(1)
		String serial = randomGenerator.generateSerial(6);
		
		//(2)
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[KH정보교육원] 이메일 인증번호입니다");
		message.setText("인증번호 : " + serial);
		javaMailSender.send(message);
		
		//(3)
		certDao.delete(email);
		CertDto certDto = CertDto.builder().who(email).serial(serial).build();
		certDao.insert(certDto);
	}
	
	@Override
	public boolean checkCert(CertDto certDto) {
		if(certDao.check(certDto)) {//인증 성공
			certDao.delete(certDto.getWho());
			return true;
		}
		return false;
	}
	
}
