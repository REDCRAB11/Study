package com.kh.springhome.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springhome.entity.GuestBookDto;
import com.kh.springhome.repository.GuestBookDao;

@Controller
@RequestMapping("/guest-book")
public class GuestBookController {
	
	@Autowired
	private GuestBookDao dao;

	@GetMapping("/insert")
	public String insert() {
		return "guestbook/insert";
	}

@PostMapping("/insert")
public String insert(@ModelAttribute GuestBookDto dto  ) {
	dao.insert(dto);
	return "redirect:insert_success"; //상대경로
//	return "redirect:/guestbook/insert_success"; 절대경로 
}
@GetMapping("/insert_success")
	public String insertSuccess() {
		return"guestbook/insertResult";
	}

}