package com.kh.spring12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring12.entity.PocketMonsterDto;
import com.kh.spring12.repository.PocketMonsterDao;

@Controller
@RequestMapping("/pocketmon")
public class PocketMonsterController {
	
	@GetMapping("/insert")
	public String insert() {
//		return "/WEB-INF/views/pocketmon/insert.jsp";
		return "pocketmon/insert";
	}
	
	@Autowired
	private PocketMonsterDao pocketMonsterDao;
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute PocketMonsterDto pocketMonsterDto) {
		pocketMonsterDao.insert(pocketMonsterDto);
		return"redirect:insert";
	}
}
