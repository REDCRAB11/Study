package com.kh.springhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 공용주소를 부여하지 않고 첫 페이지를 처리하도록 설정
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
//		return"/WEB-INF/views/home.jsp";
		return "home";
	}
	
}
