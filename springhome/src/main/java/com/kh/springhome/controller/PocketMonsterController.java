package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springhome.entity.PocketMonsterDto;
import com.kh.springhome.repository.PocketMonsterDao;

@Controller
@RequestMapping("/pocketmonster")
public class PocketMonsterController {

@Autowired
private PocketMonsterDao pocketMonsterDao;
	
	
	// 등록 기능은 매핑이 2개가 필요한데 주소는 같을 수 없다. 
	// 주소를 맞추려면 방식이라도 달라야 하므로 구분해야 한다. 
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)
//	@RequestMapping(value = "/insert", method = RequestMethod.POST) 이렇게 쓰면 너무 길어 ~ 
	
	@GetMapping("/insert")
	public String insert() {
//		return "/WEB-INF/views/pocketmon/insert.jsp";
		return"pocketmon/insert";
	}
	
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute PocketMonsterDto dto) {
		// DB insert
		pocketMonsterDao.insert(dto);
		
		// insert_success 매핑으로 redirect(강제이동) 처리하세요.
		return"redirect:insert_success";
	}
	
	@RequestMapping("/insert_success")
	public String insertSuccess() {
		return "pocketmon/insertResult";
	}
	
	
}
