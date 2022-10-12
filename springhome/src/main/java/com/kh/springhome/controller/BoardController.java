package com.kh.springhome.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.springhome.constant.SessionConstant;
import com.kh.springhome.entity.AttachmentDto;
import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.entity.MemberBoardLikeDto;
import com.kh.springhome.entity.ReplyDto;
import com.kh.springhome.error.TargetNotFoundException;
import com.kh.springhome.repository.AttachmentDao;
import com.kh.springhome.repository.BoardDao;
import com.kh.springhome.repository.MemberBoardLikeDao;
import com.kh.springhome.repository.ReplyDao;
import com.kh.springhome.service.BoardService;
import com.kh.springhome.vo.BoardListSearchVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private MemberBoardLikeDao likeDao;
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	private final File directory = new File(System.getProperty("user.home")+"/upload");
	
	@Autowired
	private BoardService boardService;

	@PostConstruct//최초 실행시 딱 한 번만 실행되는 메소드
	public void prepare() {
		directory.mkdirs();
	}
	
//	참고 : ModelAttribute로 수신한 데이터는 자동으로 Model에 첨부된다
//	- 옵션에 name을 작성하면 해당하는 이름으로 model에 첨부
	@GetMapping("/list")
	public String list(Model model,
			@ModelAttribute(name="vo") BoardListSearchVO vo) {
//		페이지 네비게이터를 위한 게시글 수를 구한다
		int count = boardDao.count(vo);
		vo.setCount(count);
		
		model.addAttribute("list", boardDao.selectList(vo));
//		return "/WEB-INF/views/board/list.jsp";
		return "board/list";
	}
	
	@GetMapping("/detail")
	public String detail(
			@RequestParam int boardNo, Model model,
			HttpSession session) {
//		1. 조회수 증가시켜서 데이터를 불러온다
//		boardDao.updateReadcount(boardNo);
//		model.addAttribute("boardDto", boardDao.selectOne(boardNo));
		
//		2. 데이터를 읽도록 처리한다
//		model.addAttribute("boardDto", boardDao.read(boardNo));
		
//		(+추가) 조회수 중복 방지 처리
//		(1) 세션에 내가 읽은 게시글의 번호를 저장할 수 있는 저장소를 구현
//		-> 후보 : int[], List<Integer>, Set<Integer>
//		-> 현재 필요한 것은 게시글을 읽은적이 있는가(중복확인)
//		-> 세션에 저장할 이름은 history로 지정
//		(2) 현재 history가 있을지 없을지 모르므로 꺼내서 없으면 생성
		
		Set<Integer> history = (Set<Integer>) session.getAttribute("history");
		if(history == null) {//history가 없다면 신규 생성
			history = new HashSet<>();
		}
		
//		(3) 현재 글 번호를 읽은적이 있는지 검사
		if(history.add(boardNo)) {//추가된 경우 - 처음 읽는 번호면
			model.addAttribute("boardDto", boardDao.read(boardNo));
		}
		else {//추가가 안된 경우 - 읽은 적이 있는 번호면
			model.addAttribute("boardDto", boardDao.selectOne(boardNo));
		}
//		System.out.println("history = " + history);
		
//		(4) 갱신된 저장소를 세션에 다시 저장
		session.setAttribute("history", history);
		
//		(+추가) 댓글 목록을 조회하여 첨부
		model.addAttribute("replyList", replyDao.selectList(boardNo));
		
//		(+추가) 좋아요 기록이 있는지 조회하여 첨부
		String loginId = (String) session.getAttribute(SessionConstant.ID);
		if(loginId != null) {
			MemberBoardLikeDto likeDto = new MemberBoardLikeDto();
			likeDto.setMemberId(loginId);
			likeDto.setBoardNo(boardNo);
			model.addAttribute("isLike", likeDao.check(likeDto));
		}
		
//		(+추가) 게시글에 대한 첨부파일을 조회하여 첨부
		model.addAttribute("attachmentList", 
				attachmentDao.selectBoardAttachmentList(boardNo));
		
		return "board/detail";
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(
			@ModelAttribute BoardDto boardDto,
			@RequestParam List<MultipartFile> attachment,
			HttpSession session, RedirectAttributes attr) throws IllegalStateException, IOException {
//		session에 있는 회원 아이디를 작성자로 추가한 뒤 등록해야함
//		String memberId = (String)session.getAttribute("loginId");
		String memberId = (String)session.getAttribute(SessionConstant.ID);
		boardDto.setBoardWriter(memberId);
		
		int boardNo = boardService.write(boardDto, attachment);
		
		attr.addAttribute("boardNo", boardNo);
		return "redirect:detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		// 삭제가 이루어지기 전에 삭제될 게시글의 첨부파일 정보를 조회 
		List<AttachmentDto> attachmentList = attachmentDao.selectBoardAttachmentList(boardNo);
		
		// 삭제: 자동으로 board_attachment의 데이터가 연쇄 삭제됨  
		boolean result = boardDao.delete(boardNo);
		
		if(result) {//Service가 해야하는 작업 
			for(AttachmentDto attachmentDto : attachmentList) {
			// 첨부파일(attachment, board_attachment)테이블 삭제
			attachmentDao.delete(attachmentDto.getAttachmentNo());
			
			// 실제파일 삭제 
			String filename = String.valueOf(attachmentDto.getAttachmentNo());
			File target = new File(directory, filename);
			target.delete();
			}
		}
		
			// 컨트롤러가 해야하는 작업 
		if(result) {//성공 
			for(AttachmentDto attachmentDto : attachmentList) {
			// 첨부파일(attachment, board_attachment)테이블 삭제
			attachmentDao.delete(attachmentDto.getAttachmentNo());
			
			// 실제파일 삭제 
			String filename = String.valueOf(attachmentDto.getAttachmentNo());
			File target = new File(directory, filename);
			target.delete();
			
			}
			
			return "redirect:list";
		}
		else {//구문은 실행되었지만 바뀐 게 없는 경우(강제 예외 처리)
			throw new TargetNotFoundException();
		}
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) {//없는 경우 내가 만든 예외 발생
			throw new TargetNotFoundException();
		}

		model.addAttribute("boardDto", boardDto);
//		return "/WEB-INF/views/board/edit.jsp";
		return "board/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto,
			RedirectAttributes attr) {
		boolean result = boardDao.update(boardDto);
		if(result) {//성공했다면 상세페이지로 이동
//			return "redirect:detail?boardNo="+boardDto.getBoardNo();
			attr.addAttribute("boardNo", boardDto.getBoardNo());
			return "redirect:detail";
		}
		else {//실패했다면 오류 발생
			throw new TargetNotFoundException();
		}
	}
	
	@PostMapping("/reply/write")
	public String replyWrite(
			@ModelAttribute ReplyDto replyDto,
			RedirectAttributes attr, HttpSession session) {
		String memberId = (String)session.getAttribute(SessionConstant.ID);
		replyDto.setReplyWriter(memberId);
		replyDao.insert(replyDto);
		
		attr.addAttribute("boardNo", replyDto.getReplyOrigin());
//		return "redirect:../detail";//상대
		return "redirect:/board/detail";//절대
	}
	
	@GetMapping("/reply/delete")
	public String replyDelete(
			@RequestParam int replyNo,
			@RequestParam int replyOrigin,
			RedirectAttributes attr) {
		replyDao.delete(replyNo);
		attr.addAttribute("boardNo", replyOrigin);
		return "redirect:/board/detail";
	}
	
	@PostMapping("/reply/edit")
	public String replyEdit(
			@ModelAttribute ReplyDto replyDto,
			RedirectAttributes attr) {
		replyDao.update(replyDto);
		attr.addAttribute("boardNo", replyDto.getReplyOrigin());
		return "redirect:/board/detail";
	}
	
	@GetMapping("/reply/blind")
	public String replyBlind(
			@RequestParam int replyNo,
			@RequestParam int replyOrigin,
			RedirectAttributes attr) {
		ReplyDto replyDto = replyDao.selectOne(replyNo);
		replyDao.updateBlind(replyNo, !replyDto.isReplyBlind());
//		if(replyDto.isReplyBlind()) {
//			replyDao.updateBlind(replyNo, false);
//		}
//		else {
//			replyDao.updateBlind(replyNo, true);
//		}
		
		attr.addAttribute("boardNo", replyOrigin);
		return "redirect:/board/detail";
	}
	
//	좋아요
	@GetMapping("/like")
	public String boardLike(
				@RequestParam int boardNo,
				HttpSession session, RedirectAttributes attr
			) {
		String memberId = (String)session.getAttribute(SessionConstant.ID);
		MemberBoardLikeDto dto = new MemberBoardLikeDto();
		dto.setMemberId(memberId);
		dto.setBoardNo(boardNo);
		
		if(likeDao.check(dto)) {//좋아요를 한 상태면
			likeDao.delete(dto);//지우세요
		}
		else {//좋아요를 한 적이 없는 상태면
			likeDao.insert(dto);//추가하세요
		}
		
		likeDao.refresh(boardNo);//조회수 갱신
		
		attr.addAttribute("boardNo", boardNo);
		return "redirect:/board/detail";
	}
	
	@GetMapping("/delete_admin")
	public String deleteAdmin(@RequestParam List<Integer> boardNo) {
		for(int no:boardNo) {
			boardDao.delete(no);
		}
		return "redirect:list";
	}
}















