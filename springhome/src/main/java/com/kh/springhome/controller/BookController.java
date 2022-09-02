package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springhome.entity.BookDto;
import com.kh.springhome.repository.BookDao;

@Controller
@RequestMapping("/boook")
public class BookController {

	@Autowired
	private BookDao dao;
	
	@GetMapping("/insert")
	public String insert() {
		return"book/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute BookDto dto) {
		dao.insert(dto);
		return"redirect:insert_success";
	}

	@GetMapping("/insert_success")
	public String insertSuccess() {
		return"book/insertSuccess";
	}
}
