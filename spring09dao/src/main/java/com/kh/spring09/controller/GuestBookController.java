package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring09.entity.GuestBookDto;
import com.kh.spring09.repository.GuestBookDao;

@Controller
public class GuestBookController {
	
	@Autowired
	private GuestBookDao guestBookDao;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute GuestBookDto dto) {
		guestBookDao.insert(dto);
		return "등록완료!";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(@ModelAttribute GuestBookDto dto) {
		boolean result =guestBookDao.update(dto);
		if(result) {
			return "변경성공!";
		}else {
			return"없는번호";
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@ModelAttribute int no) {
		boolean result = guestBookDao.delete(no);
		if(result) {
			return "삭제 완료";
		}else {
			return"없는 번호";
		}
	}
	
	// 목록 및 검사 
	@RequestMapping("/list")
	@ResponseBody
	 public String list(@RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
	
		boolean search = type != null && keyword != null; 
		List<GuestBookDto> data;
		if(search) {
			data = guestBookDao.selectList(type, keyword);
		}else {
			data = guestBookDao.selectList();
		}
		return data.toString();
	}

	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int no) {
		GuestBookDto dto = guestBookDao.selectOne(no);
		if(dto == null){
			return "없는 번호";
		}else {
			return dto.toString();
		}
	}
	
}