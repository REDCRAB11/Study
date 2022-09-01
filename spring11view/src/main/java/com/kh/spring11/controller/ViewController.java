package com.kh.spring11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tag")
public class ViewController {

	@RequestMapping("/test01")
	public String test01() {
		return "tag/test01";
	}
	
	@RequestMapping("/test02")
	public String test02() {
		return"tag/test02";
	}
	
	@RequestMapping("/test03")
	public String test03() {
		return"tag/test03";
	}
}
