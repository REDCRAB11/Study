package com.kh.spring23.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring23.entity.MemberDto;

/**
 *	웹소켓 접속을 위한 JSP를 연결해주는 컨트롤러 
 */
@Controller
@RequestMapping("/page")
public class PageController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("/home")
	public String home() {
		return"home";
	}
	
	//로그인
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		MemberDto findDto = sqlSession.selectOne("member.get", memberDto.getMemberId());
		if(findDto == null)return"redirect:home";
		
		// 비밀번호가 같은지 판정하기 
		boolean judge = memberDto.getMemberPw().equals(findDto.getMemberPw());
		
		if(judge) {
			session.setAttribute("loginId", findDto.getMemberId());
			session.setAttribute("loginNick", findDto.getMemberNick());
			session.setAttribute("loginAuth", findDto.getMemberGrade());
		}
		return"redirect:home";
	}
	
	@GetMapping("/basic")
	public String basic() {
		return "basic";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//통으로 날려버려 
		session.invalidate();
		return"redirect:home";
	}
	
	@GetMapping("/multiple")
	public String multiple() {
		return "multiple";
	}
	
	@GetMapping("/message")
	public String message() {
		return "message";
	}

	@GetMapping("/json")
	public String json() {
		return"json";
	}
	
	@GetMapping("/sockjs")
	public String sockjs() {
		return"sockjs";
	}
}




