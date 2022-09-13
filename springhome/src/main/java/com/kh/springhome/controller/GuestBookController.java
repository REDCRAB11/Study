package com.kh.springhome.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.kh.springhome.entity.MemberDto;
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

@GetMapping("/list")
public String list(Model model, @RequestParam (required = false) String type, @RequestParam (required = false) String keyword) {
	boolean isSearch = type != null && keyword != null;
	if(isSearch) {
		model.addAttribute("List", dao.selectList(type, keyword));
	}else {
		model.addAttribute("list", dao.selectList());
	}
	return "guestbook/list";
}

//상세기능
@GetMapping("/detail")
public String detail(Model model, @RequestParam int no) {
	GuestBookDto dto = dao.selectOne(no);
	model.addAttribute("dto", dto);
	return "guestbook/detail";
}

@GetMapping("/edit")
public String edit(Model model, @RequestParam int no) {
	GuestBookDto dto = dao.selectOne(no);
	model.addAttribute("dto", dto);
	return"guestbook/edit";
}

//redirect전용 저장소 (model의 자식 클래스 ) 
@PostMapping("/edit")
public String edit(@ModelAttribute GuestBookDto dto, RedirectAttributes attr) {
	attr.addAttribute("no", dto.getNo()); // 추천 (spring 도구 활용) 
	return"redirect:detail";
}

@GetMapping("/edit_fail")
public String editFail() {
	return"guestbook/editFail";
}

//삭제 detail.jsp 랑 int no no 부분 맞아야 함 
@GetMapping("/delete")
public String delete(@RequestParam int no) {
	boolean result = dao.delete(no);
	if(result) {
		return"redirect:list";
	}else {
		return"guestbook/editFail";
	}
}
}