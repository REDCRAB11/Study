package com.kh.springhome.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.springhome.constant.SessionConstant;
import com.kh.springhome.entity.MemberDto;
import com.kh.springhome.error.TargetNotFoundException;
import com.kh.springhome.repository.BoardDao;
import com.kh.springhome.repository.MemberBoardLikeDao;
import com.kh.springhome.repository.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberBoardLikeDao memberBoardLikeDao;
	
	@GetMapping("/join")
	public String join() {
//		return "/WEB-INF/views/member/join.jsp";
		return "member/join";
	}
	
//	(+추가) 첨부파일을 받아서 저장 
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto,
			@RequestParam MultipartFile memberProfile
			) throws IllegalStateException, IOException {
		
		//데이터베이스 등록
		memberDao.insert(memberDto);
		
		if(!memberProfile.isEmpty()) { // 첨부파일이 있다면 
			// 프로필 저장
			File directory = new File(System.getProperty("user.home")+"/member");
			directory.mkdirs();
			File target = new File(directory, memberDto.getMemberId());
			memberProfile.transferTo(target);	
		}
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
			session.setAttribute(SessionConstant.ID, inputDto.getMemberId());
			session.setAttribute(SessionConstant.GRADE, findDto.getMemberGrade());
			
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
		session.removeAttribute(SessionConstant.ID);
		session.removeAttribute(SessionConstant.GRADE);
		//session.invalidate();//세션 파괴(비추천, 사용자 측정 시 문제)
		return "redirect:/";
	}
	
//	마이페이지 - 현재 로그인한 회원의 정보를 화면에 출력
//	- 준비물 : HttpSession, Model
	@GetMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		//1. 세션에 들어있는 아이디를 꺼낸다
		//(참고) 세션에 데이터는 Object 형태로 저장되므로 꺼내려면 다운캐스팅 필요
		String loginId = (String) session.getAttribute(SessionConstant.ID);
		
		//2. 아이디를 이용하여 회원 정보를 불러온다
		MemberDto memberDto = memberDao.selectOne(loginId);
		
		//3. 불러온 회원 정보를 모델에 첨부한다
		model.addAttribute("memberDto", memberDto);
		
		//(+추가) 내가 작성한 게시글 최근순 5개 조회
		model.addAttribute("writeBoardList", boardDao.selectWriteList(loginId, 1, 10));
		
		//(+추가) 내가 좋아요한 게시글 최근순 5개 조회
		model.addAttribute("likeBoardList", boardDao.selectLikeList(loginId, 1, 10));
		
		//4. 화면(View)으로 전달(Forward)한다
		//(참고) 기존에 사용하던 회원상세(detail.jsp) 뷰와 같이 사용
		//return "/WEB-INF/views/member/detail.jsp";
		return "member/detail";
	}
	
//	비밀번호 변경 기능
	@GetMapping("/password")
	public String password() {
//		return "/WEB-INF/views/member/password.jsp";
		return "member/password";
	}
	
	@PostMapping("/password")
	public String password(
			HttpSession session, 
			@RequestParam String beforePw,//사용자가 입력한 기존비밀번호
			@RequestParam String afterPw) {//사용자가 입력한 바꿀비밀번호
		String memberId = (String) session.getAttribute(SessionConstant.ID);
		try {
			//비밀번호 검사
			MemberDto memberDto = memberDao.selectOne(memberId);
			boolean passwordMatch = beforePw.equals(memberDto.getMemberPw());
			if(!passwordMatch) {
				//return "redirect:password?error";
				throw new Exception();
			}
			
			//비밀번호 변경
			memberDao.changePassword(memberId, afterPw);
			return "redirect:password_result";
		}
		catch(Exception e) {
			return "redirect:password?error";
		}
	}
	
	@GetMapping("/password_result")
	public String passwordResult() {
		return "member/passwordResult";
	}
	
	
//	개인정보 변경 기능(자신)
//	1. 자신의 현재 정보를 조회하여 화면에 출력
//	2. 바꾸고 싶은 정보를 입력하여 전송하면 해당 정보를 변경
	@GetMapping("/information")
	public String information(HttpSession session, Model model) {
		//(1) 자신의 아이디를 획득(HttpSession)
		String memberId = (String)session.getAttribute(SessionConstant.ID);
		
		//(2) 아이디로 정보를 조회
		MemberDto memberDto = memberDao.selectOne(memberId);
		
		//(3) 조회한 정보를 화면으로 전달
		model.addAttribute("memberDto", memberDto);
		
		//(4) 연결될 화면 주소를 반환
		//return "/WEB-INF/views/member/information.jsp";
		return "member/information";
	}
	
	@PostMapping("/information")
	public String information(
			HttpSession session, 
			@ModelAttribute MemberDto inputDto) {
		//memberDto에 memberId가 없으므로 세션에서 구해서 추가 설정해야함
		String memberId = (String)session.getAttribute(SessionConstant.ID);
		inputDto.setMemberId(memberId);
		
		//(1) 비밀번호를 검사
		MemberDto findDto = memberDao.selectOne(memberId);
		boolean passwordMatch = 
				inputDto.getMemberPw().equals(findDto.getMemberPw());
		
		if(passwordMatch) {
			//(2) 비밀번호 검사를 통과했다면 정보를 변경하도록 처리
			memberDao.changeInformation(inputDto);
			return "redirect:mypage";
		}
		else {//비밀번호가 틀린 경우
			return "redirect:information?error";
		}
	}
	
	@GetMapping("/goodbye")
	public String goodbye() {
//		return "/WEB-INF/views/member/goodbye.jsp";
		return "member/goodbye";
	}
	
	@PostMapping("/goodbye")
	public String goodbye(HttpSession session, 
						@RequestParam String memberPw) {
		String memberId = (String)session.getAttribute(SessionConstant.ID);
		MemberDto memberDto = memberDao.selectOne(memberId);
		boolean passwordMatch = 
				memberPw.equals(memberDto.getMemberPw());
		if(passwordMatch) {
			//회원 탈퇴
			memberDao.delete(memberId);
			//로그 아웃
			session.removeAttribute(SessionConstant.ID);
			session.removeAttribute(SessionConstant.GRADE);
			return "redirect:goodbye_result";
		}
		else {
			return "redirect:goodbye?error";
		}
	}
	
	@GetMapping("/goodbye_result")
	public String goodbyeResult() {
//		return "/WEB-INF/views/member/goodbyeResult.jsp";
		return "member/goodbyeResult";
	}
	
// (+추가) 특정 사용자의 프로필 이미지를 다운로드하는 매핑  
// - 다운로드란 현재의 서버에서 사용자에게 파일을 전송하는 것 
//	 - 전송을 하려면 화면을 무시해야하는 설정을 해야한다. (@ResponseBody)
//	- 전송을 부탁하려면 ResponseEntitiy 형태가 반환되어야 한다. 
	
	@GetMapping("/download")
	@ResponseBody
	public ResponseEntity<ByteArrayResource> download(@RequestParam String memberId) throws IOException {
		// [1] 파일 찾기 
		File directory = new File(System.getProperty("user.home")+"/member");
		File target = new File(directory, memberId);
		
		if(target.exists()) {// 파일 존재
			
			// [2] 해당 파일의 내용을 불러온다.(apache commons io 의존성 필요) 
			byte[] data = FileUtils.readFileToByteArray(target);
			ByteArrayResource resource = new ByteArrayResource(data);
			
			// [3] 사용자에게 보낼 응답 생성
			// - header에는 보낼 파일의 정보를, body에는 보낼 파일의 내용을 첨부 
			return ResponseEntity.ok().header("Content-Encofing", "UTF-8")
					.header("Content-Length", String.valueOf(data.length))
					.header("Content-Disposition", "attachment;filename=" + memberId)
					.header("Content-Type", "application/octet-stream")
					.body(resource);
			
		}else {// 파일 없음  둘 중 하나 쓰세요  ~ 
			// 1) 우리가 정한 예외를 발생시키는 방법 구현은 이게 낫다 
			throw new TargetNotFoundException("프로필 없음");
			
			// 2) 사용자에게 못찾았음(404)를 전송 
//			return ResponseEntity.notFound().build();
		}
	}
	
}