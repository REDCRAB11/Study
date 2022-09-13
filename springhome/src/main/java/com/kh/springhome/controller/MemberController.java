

package com.kh.springhome.controller;

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

import com.kh.springhome.entity.MemberDto;
import com.kh.springhome.repository.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/join")
	public String join() {
//		return "/WEB-INF/views/member/join.jsp";
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:join_finish";
	}
	
	@GetMapping("/join_finish")
	public String joinFinish() {
//		return "/WEB-INF/views/member/joinFinish.jsp";
		return "member/joinFinish";
	}
	
	@GetMapping("/list")
	public String list(Model model,
				@RequestParam(required = false) String type,
				@RequestParam(required = false) String keyword) {
		boolean isSearch = type != null && keyword != null;
		if(isSearch) {
			model.addAttribute("list", memberDao.selectList(type, keyword));
		}
		else {
			model.addAttribute("list", memberDao.selectList());
		}
		return "member/list";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, 
					@RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto", memberDto);
//		return "/WEB-INF/views/member/detail.jsp";
		return "member/detail";
	}
	
	@GetMapping("/change")
	public String change(Model model, @RequestParam String memberId) {
		model.addAttribute("memberDto", memberDao.selectOne(memberId));
//		return "/WEB-INF/views/member/change.jsp";
		return "member/change";
	}
	
	@PostMapping("/change")
	public String change(@ModelAttribute MemberDto memberDto,
								RedirectAttributes attr) {
		boolean result = memberDao.update(memberDto);
		if(result) {
			attr.addAttribute("memberId", memberDto.getMemberId());
			return "redirect:detail";
		}
		else {
			return "redirect:change_fail";
		}
	}
	
	@GetMapping("/change_fail")
	public String changeFail() {
//		return "/WEB-INF/views/member/changeFail.jsp";
		return "member/changeFail";
	}
	
	@GetMapping("/exit")
	public String exit(@RequestParam String memberId) {
		boolean result = memberDao.delete(memberId);
		if(result) {
			return "redirect:list";
		}
		else {
			return "member/changeFail";
		}
	}
	
	@GetMapping("/login")
	public String login() {
//		return "/WEB-INF/views/member/login.jsp";
		return "member/login";
	}
	
	//1. 데이터베이스에서 아이디에 해당하는 정보를 불러온다
	//2. 불러온 정보의 비밀번호와 사용자가 입력한 비밀번호를 비교한다
	//<결과>
	//a. 1번이 실패할 경우 → 로그인 실패(아이디 없음)	
	//b. 1번은 성공했으나 2번이 실패할 경우 → 로그인 실패(비밀번호 틀림)
	//c. 1번과 2번이 모두 성공할 경우 → 로그인 성공
	@PostMapping("/login")
	public String login(
			@ModelAttribute MemberDto inputDto,
			HttpSession session) {
		MemberDto findDto = memberDao.selectOne(inputDto.getMemberId());
		if(findDto == null) {//a
			return "redirect:login?error";//redirect는 언제나 GET방식
		}
		
		//inputDto는 사용자가 입력한 정보, findDto는 데이터베이스 조회 결과
		boolean passwordMatch = 
				inputDto.getMemberPw().equals(findDto.getMemberPw());
		if(passwordMatch) {//c
			
			//HttpSession에 이 사용자가 로그인 했음을 기록
			//- 필요 시 컨트롤러 매개변수에 해당 변수를 선언
			//- key=value 형태로 관리되는 저장소이며 다음의 명령이 존재
			//- session.setAttribute("이름", 값);
			//- session.getAttribute("이름");
			//- session.removeAttribute("이름");
			session.setAttribute("loginId", inputDto.getMemberId());
			session.setAttribute("mg",findDto.getMemberGrade());
			
			return "redirect:/";
		}
		else {//b
			return "redirect:login?error";//redirect는 언제나 GET방식
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1. 세션의 loginId라는 이름의 데이터를 삭제
		//2. 메인 페이지로 강제 이동
		session.removeAttribute("loginId");
		session.removeAttribute("mg");
//		session.invalidate(); 세션 파괴(비추천, 사용자 측정 시 문제)
		return "redirect:/";
	}
		
	// 마이페이지 - 현재 로그인한 회원의 정보를 화면에 출력 
	// - 준비물: HttpSession, Model 
		@GetMapping("/mypage")
		public String mypage(Model model,HttpSession session) {
			// 1. 세션에 들어있는 아이디를 꺼낸다.
			// 참고! 세션에 데이터는 Object 형태로 저장되므로 꺼내려면 다운캐스팅 
			String loginId = (String) session.getAttribute("loginId");
			// 2. 아이디를 이용하여 회원 정보를 불러온다. 
			MemberDto memberDto = memberDao.selectOne(loginId);
			// 3. 불러온 정보를 모델에 첨부한다.
			model.addAttribute("memberDto", memberDto);
			// 4. 화면(view)로 전달(Forward)한다. 
			// 참고! 기존에 사용하던 회원상세(detail.jsp) 뷰와 같이 사용 
			return"member/detail";
		}
		
}

