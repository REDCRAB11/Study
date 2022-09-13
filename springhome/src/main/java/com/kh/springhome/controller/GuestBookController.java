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

import com.kh.springhome.entity.GuestBookDto;
import com.kh.springhome.repository.GuestBookDao;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	@Autowired
	private GuestBookDao guestBookDao;
	
	@GetMapping("/insert")
	public String insert() {
//		return "/WEB-INF/views/guestbook/insert.jsp";
		return "guestbook/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute GuestBookDto dto) {
		guestBookDao.insert(dto);
		return "redirect:insert_success";//상대경로
//		return "redirect:/guestbook/insert_success";//절대경로
	}
	
	@GetMapping("/insert_success")
	public String insertSuccess() {
//		return "/WEB-INF/views/guestbook/insertSuccess.jsp";
		return "guestbook/insertSuccess";
	}
	
	@GetMapping("/list")
	public String list(Model model, 
					@RequestParam(required = false) String type,
					@RequestParam(required = false) String keyword) {
		boolean isSearch = type != null && keyword != null;
		if(isSearch) {//검색
			model.addAttribute("list", guestBookDao.selectList(type, keyword));
		}
		else {//목록
			model.addAttribute("list", guestBookDao.selectList());
		}
		
		return "guestbook/list";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int no) {
		model.addAttribute("dto", guestBookDao.selectOne(no));
//		return "/WEB-INF/views/guestbook/detail.jsp";
		return "guestbook/detail";
	}
	
//	수정
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int no) {
		model.addAttribute("dto", guestBookDao.selectOne(no));
//		return "/WEB-INF/views/guestbook/edit.jsp";
		return "guestbook/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute GuestBookDto dto,
								//redirect 전용 저장소(Model의 자식클래스)
								RedirectAttributes attr) {
		boolean result = guestBookDao.update(dto);
		if(result) {
//			return "redirect:detail?no="+dto.getNo();//비추천(직접작성)
			attr.addAttribute("no", dto.getNo());//추천(Spring 도구 활용)
			return "redirect:detail";
		}
		else {
			return "redirect:edit_fail";
		}
	}
	
	@GetMapping("/edit_fail")
	public String editFail() {
//		return "/WEB-INF/views/guestbook/editFail.jsp";
		return "guestbook/editFail";
	}
	
//	삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int no) {
		boolean result = guestBookDao.delete(no);
		if(result) {
			return "redirect:list";
		}
		else {
			return "guestbook/editFail";
		}
	}
	
}