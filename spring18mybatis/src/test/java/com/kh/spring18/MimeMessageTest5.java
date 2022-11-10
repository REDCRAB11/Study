package com.kh.spring18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
public class MimeMessageTest5 {
	
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
		helper.setSubject("[나나드림]jsoup 테스트애옹");
		ClassPathResource resource = new ClassPathResource("email/template3.html");
		StringBuffer buffer = new StringBuffer();
		try(Scanner sc = new Scanner(resource.getFile())){
			while(sc.hasNextLine()) {
				buffer.append(sc.nextLine());
			}
		}
		
		//Jsoup 라이브러리를 사용하여 ID와 Address를 설정한 뒤 전송 
		String text = buffer.toString();
		
		//불러온 문자열을 HTML로 파싱(해석) 
		Document doc = Jsoup.parse(text);
		//id=user-name 선택해라 
		Element element = doc.getElementById("user-name");
		//선택한 대상에 text를 설정 
		element.text("jaemini4ever");
		
		Element link = doc.getElementById("return-url");
		link.attr("href", "http://localhost:8888/async1");
		
		helper.setText(doc.toString(), true);
		
		//4. 전송
		javaMailSender.send(message);
	}
}