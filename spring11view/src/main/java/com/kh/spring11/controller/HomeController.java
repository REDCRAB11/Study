package com.kh.spring11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/hello")
	public String hello() {
//		return "/WEB-INF/views/hello.jsp";
		return "hello";
	}
}
