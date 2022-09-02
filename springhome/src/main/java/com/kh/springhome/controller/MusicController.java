package com.kh.springhome.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springhome.entity.MusicDto;
import com.kh.springhome.repository.MusicDao;


@Controller
@RequestMapping("/musici")
public class MusicController {
	
	@Autowired
	public MusicDao dao;
	
	@GetMapping("/insert")
	public String insert() {
		return"music/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MusicDto dto) {
		dao.insert(dto);
		return"redirect:insert_success";
	}
	
	@GetMapping("/insert_success")
	public String insertSuccess() {
		return"music/insertSuccess";
	}
	
	
}
