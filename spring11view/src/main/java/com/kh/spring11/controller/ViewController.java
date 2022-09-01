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
	
	@RequestMapping("/sns")
	public String sns() {
		return "tag/sns";
	}
	
	@RequestMapping("/test05")
	public String test05() {
		return "tag/test05";
	}
	
	@RequestMapping("/test06")
	public String test06() {
		return"tag/test06";
	}
	
	@RequestMapping("/test07")
	public String test07() {
		return"tag/test07";
	}
	
	@RequestMapping("/test08")
	public String test08() {
		return"tag/test08";
	}
}
