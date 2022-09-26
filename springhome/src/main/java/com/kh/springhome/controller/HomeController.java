package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springhome.repository.BoardDao;
import com.kh.springhome.repository.GuestBookDao;
import com.kh.springhome.repository.MemberDao;
import com.kh.springhome.repository.MusicDao;
import com.kh.springhome.repository.PocketMonsterDao;

@Controller
//공용 주소를 부여하지 않고 첫 페이지를 처리하도록 설정
public class HomeController {
	
	@Autowired
	private PocketMonsterDao pocketMonsterDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private GuestBookDao guestBookDao;
	
	@Autowired
	private MusicDao musicDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("memberList", memberDao.selectListForMain());
		model.addAttribute("boardList", boardDao.selectListForMain());
		model.addAttribute("pocketmonList", pocketMonsterDao.selectListForMain());
		model.addAttribute("guestBookList", guestBookDao.selectListForMain());
		model.addAttribute("musicList", musicDao.selectListForMain());
		
//		return "/WEB-INF/views/home.jsp";
		return "home";
	}
	
}