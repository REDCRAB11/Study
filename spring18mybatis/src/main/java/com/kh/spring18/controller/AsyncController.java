package com.kh.spring18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring18.entity.CertDto;
import com.kh.spring18.service.EmailService;

@Controller
public class AsyncController {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/async1")
	public String async1() {
		return "async1";
	}
	
	//비동기 통신은 화면을 줄 필요가 없어서 @ResponseBody를 붙여서 데이터를 전달한다. 
	@PostMapping("/async2")
	@ResponseBody
	public void async2(@RequestParam String who) {
		emailService.sendCertMail(who);
	}
@PostMapping("/async3")
@ResponseBody
public boolean async3(@ModelAttribute CertDto cerDto) {
	return emailService.checkCert(cerDto);
	}
}
