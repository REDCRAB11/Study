package com.kh.spring02.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 접속 처리 도구 등록 annotation
public class HomeController {

		@RequestMapping("/test") // 매핑 생성 annotation
		@ResponseBody // 화면을 쓰지 않겠다. 
		public String test() {
			return "Hello Spring Boot!";
		}
		
		@RequestMapping("/dice")
		@ResponseBody 
		public String dice() {
			Random r  = new Random();
			int dice = r.nextInt(6)+1;
			return "주사위:  " + dice;
		}
	
		//Q. lotto 주소로 접속하면 로또 번호 추첨 
		
		@RequestMapping("/lotto")
		@ResponseBody
		public String lotto() {
			Random r = new Random();
			int lotto = r.nextInt(45) +1;
			return"로또번호: " + lotto;
		}
		
		
}
