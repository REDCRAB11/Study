package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springhome.repository.MusicDao;
import com.kh.springhome.repository.PocketMonsterDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private PocketMonsterDao pocketMonsterDao;
	
	@Autowired
	private MusicDao musicDao;
	
	@GetMapping("/home")
	public String home() {
//		return "/WEB-INF/views/admin/home.jsp";
		return "admin/home";
	}
	
	@GetMapping("/pocketmon")
	public String pocketmon(Model model) {
		model.addAttribute("list", pocketMonsterDao.selectCountList());
//		return "/WEB-INF/views/admin/pocketmon.jsp";
		return "admin/pocketmon";
	}

	// 내가푼거 ~
//	@GetMapping("/music")
//	public String music(Model model) {
//		model.addAttribute("play", musicDao.selectCountList());
//		return"admin/music";
//	}
	
	@GetMapping("/music/play")
	public String musicPlay(Model model) {
		model.addAttribute("list", musicDao.top10());
		return"admin/music/play";
	}
	
	@GetMapping("/music/play/{limit}")
	public String musicPlay(Model model, @PathVariable int limit) {
		model.addAttribute("list", musicDao.topN(limit));
		return"admin/music/play";
	}
	
}
