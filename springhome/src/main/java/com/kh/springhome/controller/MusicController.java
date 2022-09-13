package com.kh.springhome.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.springhome.entity.MusicDto;
import com.kh.springhome.repository.MusicDao;


@Controller
@RequestMapping("/music")
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
	
	@GetMapping("/list")
	public String list(Model model, @RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
		boolean isSearch = type != null && keyword != null;
		if(isSearch) {
				model.addAttribute("list", dao.selectList(type, keyword));
		}else {
				model.addAttribute("list", dao.selectList());
		}
		return "music/list";
	}
	
		// 상세기능
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int musicNo) {
		MusicDto dto = dao.selectOne(musicNo);
		model.addAttribute("dto", dto);
		return "music/detail";
	}
	
	//수정기능
	
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int musicNo) {
		model.addAttribute("dto", dao.selectOne(musicNo));
		return"music/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MusicDto dto, RedirectAttributes attr) {
		boolean result = dao.update(dto);
		if(result) {
//			return"redirect:detail?musicNo="+dto.getMusicNo();
			attr.addAttribute("musicNo", dto.getMusicNo());
			return"redirect:detail";
		}else {
			return"redirect:edit_fail";
		}
	}
	@GetMapping("detail_fail")
	public String editFail() {
		// 내용이 같다는 존재하에...
//		return"music/editFail";
		return"guestbook/editFail";
	}
	
	//삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int musicNo) {
		boolean result = dao.delete(musicNo);
		if(result) {
			return"redirect:list";
		}else {
			return"guestbook/editFail";
		}
	}
}
