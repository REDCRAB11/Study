package com.kh.spring18;

import java.io.File;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
public class MimeMessageTest2 {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void test() throws MessagingException {
		//1. 메세지 생성
		MimeMessage message = javaMailSender.createMimeMessage();
		
		//2.헬퍼 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		//3. 정보 설정
		helper.setTo("jaemini4ever@gmail.com");
		helper.setSubject("[나나드림]첨부파일 테스트");
		helper.setText("첨부파일 확인해주세옹");
		
		// 이메일 첨부는 DataSource라는 형태로 해야한다. 
		File target = new File("jiin_park/git/kh10", "제목 없는 다이어그램.drawio");
		DataSource source = new FileDataSource(target);
		helper.addAttachment(target.getName(), source);
		
		//4. 전송
		javaMailSender.send(message);
	}
}