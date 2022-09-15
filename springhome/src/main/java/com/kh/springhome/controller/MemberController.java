

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
			
			
			//로그인 시간을 갱신시키는 작업 
			
			memberDao.updateLoginTime(inputDto.getMemberId());
			
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
		
		
		@GetMapping("/password")
		public String password() {
			return"member/password";
		}
		
		// 밑에 포스트 두개 내가 푼거 
		
//		@PostMapping("/password")
//		public String password(@ModelAttribute MemberDto checkDto, HttpSession session) {
//			String memberId = (String) session.getAttribute("loginId");
//			MemberDto memberDto = memberDao.selectOne(memberId);
//			boolean result = checkDto.getMemberPw().equals(memberDto.getMemberPw());
//			if(result) {
//				memberDao.updateChange(memberId, checkDto.getMemberChangePw());
//				return"redriect:/";
//			}else {
//				return "member/changeFail";
//			}
//		}
		
//		@PostMapping("/password")
//		public String password(@ModelAttribute MemberDto checkDto, Model model) {
//			MemberDto okDto = memberDao.selectOne(checkDto.getMemberPw());
//			boolean result = memberDao.update(checkDto);
//			if(result) {
//				model.addAttribute("memberPw", okDto.getMemberPw());
//				return"redriect:/";
//			}else {
//				return "member/passwordFail";
//			}
//		}

		
		
		
		// 비밀번호 변경 기능 
		
		@PostMapping("/password")
		public String password(HttpSession session , 
				@RequestParam String beforePw, // 기존 비밀번호 
				@RequestParam String afterPw // 바꿀 비밀번호 
				) {
			String memberId = (String) session.getAttribute("loginId");
//			boolean result = memberDao.changePassword(memberId, memberPw);
//			if(result) {
//				return"redirect:passwordFail";
//			}else {
//				return"redirect:password?error";
//			}
			
			try {
				//비밀번호 검사 
				MemberDto memberDto = memberDao.selectOne(memberId);
				boolean passwordMatch = beforePw.equals(memberDto.getMemberPw());
				if(! passwordMatch) {
					throw new Exception();
				}
				
				// 비밀번호 변경
				memberDao.changePassword(memberId, afterPw);
				return"redirect:passwordFail";
			}
			catch(Exception e ){
				return"redirect:password?error";
			}
		}
//		
		@GetMapping("/passwordFail")
		public String passwordFail() {
			return"member/passwordFail";
		}
		// 개인정보 변경 기능(자신)
		// 1. 자신이 현재 정보를 조회하여 화면에 출력
		// 2. 바꾸고 싶은 정보를 입력하여 전송하면 해당 정보를 변경 
		
		@GetMapping("/information")
		public String information(HttpSession session, Model model) {
			// (1) 자신의 아이디를 획득 
			String memberId = (String)session.getAttribute("loginId"); // 아이디 빼오는건 무조건 이거 외우셔 
			
			// (2) 아이디로 정보를 조회 
			MemberDto memberDto = memberDao.selectOne(memberId);
			
			// (3) 조회한 정보를 화면으로 전달 
			model.addAttribute("memberDto", memberDto);
			
			// (4) 연결될 화면 를 반환 
			return"member/information";
		}
		
		@PostMapping("/information")
		public String information(HttpSession session, @ModelAttribute MemberDto inputDto, RedirectAttributes attr){
			// memberDto에 memberId가 없으므로 세션에서 구해서 추가 설명 	
			String memberId = (String) session.getAttribute("loginId");
			inputDto.setMemberId(memberId);
			
			// (1) 비밀번호 검사 
			MemberDto findDto = memberDao.selectOne(memberId);
			boolean passwordMatch = inputDto.getMemberPw().equals(findDto.getMemberPw());

			if(passwordMatch) {
				memberDao.changeInformation(inputDto);
				return"redirect:mypage";
				// (2) 비밀번호 검사를 통과했다면 정보를 변경하도록 처리 
			}else {// 비밀번호가 틀린 경우 
				return"redirect:information?error";
			}
		}
		
		// 굳이 이렇게 아이디를 가져올 필요는 없다. 
//		@GetMapping("/goodbye")
//		public String goodbye(HttpSession session, Model model) {
//			String loginId = (String) session.getAttribute("loginId");
//			MemberDto memberDto = memberDao.selectOne(loginId);
//			model.addAttribute("memberDto", memberDto);
//			return"member/goodbye";
//			
//		}
		
		@GetMapping("/goodbye")
		public String goodbye() {
			return"member/goodbye";
		}

		@PostMapping("/goodbye")
		public String goodbye(HttpSession session, @RequestParam String memberPw) {
			String memberid = (String)session.getAttribute("loginId");
			MemberDto memberDto = memberDao.selectOne(memberid);
			boolean passwordMatch = memberPw.equals(memberDto.getMemberPw());
			if(passwordMatch) {
				//회원 탈퇴
				memberDao.delete(memberid);
				//로그 아웃
				session.removeAttribute("loginId");
				session.removeAttribute("mg");
				return"redirect:goodbye_result";
			}else {
				return"redirect:goodbye?error";
			}
		}
		
//		@PostMapping("/goodbye")
//		public String goodbye(@ModelAttribute MemberDto inputDto, HttpSession session) {
//			String memberId = (String)session.getAttribute("loginId");
//			MemberDto fidDto = memberDao.selectOne(memberId);
//			boolean passwordMatch = inputDto.getMemberPw().equals(fidDto.getMemberPw());
//			if(passwordMatch) {
//				memberDao.changeInformation(inputDto);
//				return"redirect:/";
//			}else {
//				return"redirect:goodbye_result";
//			}
//		}
		
		//	 비회원이 보는 것 
		
		@GetMapping("/goodbye_result")
		public String goodbyeResult() {
			return"member/goodbyeResult";
		}
		
//		@GetMapping("/goodbye_result")
//		public String goodbyeResult(@RequestParam String memberId) {
//			boolean result = memberDao.delete(memberId);
//			if(result) {
//				return"rediect:goodbye";
//			}else {
//				return"member/goodbyeResult";
//			}
//		}

}