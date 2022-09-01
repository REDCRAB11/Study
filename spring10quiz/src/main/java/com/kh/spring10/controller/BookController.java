package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring10.entity.BookDto;
import com.kh.spring10.repository.BookDao;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookDao bookDao;
	

	@RequestMapping("/add")
	@ResponseBody
	public String add(@ModelAttribute BookDto dto) {
		bookDao.insert(dto);
		return "도서 등록 완료";
	}
	
//	@RequestMapping("/update")
//	@ResponseBody
//	public String update(@ModelAttribute BookDto dto) {
//		boolean result = bookDao.update(dto);
//				if(result) {
//					return"수정완료";
//				}else {
//					return"없는번호";
//					
//				}
//	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(@ModelAttribute BookDto dto) {
		if(bookDao.update(dto)) {//성공(실행이 되고 바뀐 데이터가 있는 경우)
			return "도서 정보 변경 완료";
		}
		else {//실패(실행은 됐지만 바뀐 데이터가 없는 경우)
			return "등록된 도서가 아닙니다";
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int serial) {
		if(bookDao.delete(serial)) {
			return"삭제완료";
		}else {
			return"없는번호";
		}
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(@RequestParam(required = false)String genre, @RequestParam(required = false) String keyword) {
		boolean search = genre != null && keyword != null;
		List<BookDto> data;
		if(search) {
			data = bookDao.selectList(genre, keyword);
		}else {
			data = bookDao.selectList();
		}
		return data.toString();
	}
	
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int serial) {
		BookDto dto  = bookDao.selecOne(serial);
		if(dto == null) {
			return"없는번호";
		}else {
			return dto.toString();
		}
	}
	
}
