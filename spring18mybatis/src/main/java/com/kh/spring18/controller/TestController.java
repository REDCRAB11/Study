package com.kh.spring18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring18.entity.CertDto;
import com.kh.spring18.service.EmailService;

@Controller
public class TestController {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/test1")
	public String test1() {
		return "test1";
	}
	@RequestMapping("/test2")
	public String test2(@RequestParam String who, Model model) {
		emailService.sendCertMail(who);
		model.addAttribute("who", who);
		return"test2";
	}
	
	@RequestMapping("/test3")
	public String test3(@ModelAttribute CertDto certDto, RedirectAttributes attr) {
		boolean result = emailService.checkCert(certDto);
		if(result) {
			return"redirect:test4";
		}else {
			attr.addAttribute("who, cerDto.getWho");
			return"redirect:test2?error";
		}
	}
	@RequestMapping("/test4")
	public String test4() {
		return"test4";
	}
}
