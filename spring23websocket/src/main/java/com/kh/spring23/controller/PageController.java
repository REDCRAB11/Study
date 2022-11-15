package com.kh.spring23.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *	웹소켓 접속을 위한 JSP를 연결해주는 컨트롤러 
 */
@Controller
@RequestMapping("/page")
public class PageController {
	
	@GetMapping("/basic")
	public String basic() {
		return "basic";
	}
	
	@GetMapping("/multiple")
	public String multiple() {
		return "multiple";
	}
	
	@GetMapping("/message")
	public String message() {
		return "message";
	}

	@GetMapping("/json")
	public String json() {
		return"json";
	}
	
	@GetMapping("/sockjs")
	public String sockjs() {
		return"sockjs";
	}
}




