package com.kh.spring18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
public class MimeMessageTest3 {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	public void test() throws MessagingException, FileNotFoundException, IOException {
		//1. 메세지 생성
		MimeMessage message = javaMailSender.createMimeMessage();
		
		//2.헬퍼 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		//3. 정보 설정
		helper.setTo("jaemini4ever@gmail.com");
		helper.setSubject("[나나드림]html 테스트애옹");
		ClassPathResource resource = new ClassPathResource("email/template.html");
		StringBuffer buffer = new StringBuffer();
		try(Scanner sc = new Scanner(resource.getFile())){
			while(sc.hasNextLine()) {
				buffer.append(sc.nextLine());
			}
		}
		helper.setText(buffer.toString(), true);
		//4. 전송
		javaMailSender.send(message);
	}
}