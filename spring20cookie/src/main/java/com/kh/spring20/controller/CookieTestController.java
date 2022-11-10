package com.kh.spring20.controller;

import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieTestController {
	@RequestMapping("/home")
	public String home() {
		return"home";
	}
	
	@GetMapping("/create")
	public String create(HttpServletResponse response) {
		// 쿠키 생성 
		// - 쿠키는 Spring 전용이 아니라 웹 표준이다. 
		// - 쿠키는 반드시 key=value 형태여야 한다. 
		// - 쿠키를 사용자에게 보내기 위해 HttpServletResonse 객체 필요 
		Cookie ck = new Cookie("popup", "GOTOHELL");
		response.addCookie(ck);
		return"redirect:home";
	}
	
	@GetMapping("/create2")
	public String create2(HttpServletResponse response) {
		Cookie ck = new Cookie("popup", "GOTOHELL");
		//ck.setMaxAge(10);//10초 뒤 파기
		ck.setMaxAge(24*60*60);//24시간 뒤 파기 
		response.addCookie(ck);
		return"redirect:home";
	}
	
	@GetMapping("/create3")
	public String create3(HttpServletResponse response) {
		// 자정까지 남은 초 계산 
		Calendar c = Calendar.getInstance();
		long current = c.getTimeInMillis();
		
		c.add(Calendar.DATE, 1);// 다음날
		c.set(Calendar.HOUR_OF_DAY, 0); // 0시
		c.set(Calendar.MINUTE, 0);// 0분
		c.set(Calendar.SECOND, 0);// 0초
		long future = c.getTimeInMillis();
		long diff = future-current;
		
		Cookie ck = new Cookie("popup", "GOTOHELL");
		ck.setMaxAge((int)diff/1000);// 오늘 자정에 삭제  
		response.addCookie(ck);
		return"redirect:home";
	}
	// 쿠키는 삭제 명령은 없고 시간을 0으로 설정해서 지운다. 
	@GetMapping("/delete")
	public String delete(HttpServletResponse response) {
		Cookie ck = new Cookie("popup", "GOTOHELL");
		ck.setMaxAge(0);  
		response.addCookie(ck);
		return"redirect:home";
	}
}
