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

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.repository.BoardDao;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("/write")
	public String write() {
		return"board/write";
	}
	
	@PostMapping("/write")
	public String insert(@ModelAttribute BoardDto dto) {
		boardDao.write(dto);
		return"redirect:write_full";
	}
	
	@GetMapping("/write_full")
	public String insertFull() {
		return"board/writeFull";
	}
	
	@GetMapping("/list")
	public String list(Model model, @RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
		boolean isSearch = type != null && keyword != null; 
		if(isSearch) {
			model.addAttribute("list", boardDao.selectList(type, keyword));
		}else {
			model.addAttribute("list", boardDao.selectList());
		}
		return"board/list";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		return"board/detail";
	}
	
//	@GetMapping("/detail")
//	public String detail(Model model, @RequestParam(required = false) String boardWriter) {
//		model.addAttribute("dto", boardDao.selectOne(boardWriter));
//		return"board/detail";
//	}
	
	@GetMapping("/delete") // 왜 삭제가 안되고 수정실패로 넘어갈까 
	public String delete(@RequestParam(value="boardWriter", required=false) String boardWriter) {
		boolean result = boardDao.delete(boardWriter);
		if(result) {
			return"redirect:list";
		}else {
			return"board/editFail";
		}
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam(required = false) String boardWriter) {
		model.addAttribute("boardDto", boardDao.selectOne(boardWriter));
		return"board/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto dto, RedirectAttributes attr) {
		boolean result = boardDao.update(dto);
		if(result) {
			attr.addAttribute("boardWriter", dto.getBoardWriter());
			return"redirect:detail";
		}else {
			return"redirect:edit_fail";
		}
	}
	
	@GetMapping("/edit_fail")
	public String editFail() {
		return"board/editFail";
	}
}
