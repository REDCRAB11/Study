package com.kh.springhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 음원 순위 ~ ~ ~ 
	
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
	
	@GetMapping("/music/play2")
	public String musicPlay2(Model model, @RequestParam(required = false, defaultValue="1") int begin, @RequestParam(required = false, defaultValue ="10") int end){
		model.addAttribute("list", musicDao.topNtoM(begin, end));
		return"admin/music/play";
	}
	
	@GetMapping("/music/play3")
	public String musicPlay3(Model model, @RequestParam(required = false, defaultValue="1") int page, @RequestParam(required = false, defaultValue ="10") int size){
		int end = page * size;
		int begin = end - (size-1);
		model.addAttribute("list", musicDao.topNtoM(begin, end));
		return"admin/music/play";
	}
	
	// 연도별 음원 발매 숫자 통계 출력 ~ ~ ~ 
	
	@GetMapping("/music/release")
	public String musicRelease(Model model) {
//		model.addAttribute("list", musicDao.releaseByYear());
		model.addAttribute("list", musicDao.releaseByYearWithRank());
		return"admin/music/release";
	}
	
}
