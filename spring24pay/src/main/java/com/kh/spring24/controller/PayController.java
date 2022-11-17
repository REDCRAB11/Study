package com.kh.spring24.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring24.entity.MemberDto;

@Controller
public class PayController {
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto,
			HttpSession session) {
		MemberDto findDto = sqlSession.selectOne(
					"member.get", memberDto.getMemberId());
		if(findDto == null) return "redirect:/";
		
		boolean judge = memberDto.getMemberPw()
											.equals(findDto.getMemberPw());
		if(judge) {
			session.setAttribute("loginId", findDto.getMemberId());
			session.setAttribute("loginNick", findDto.getMemberNick());
			session.setAttribute("loginAuth", findDto.getMemberGrade());
		}
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}