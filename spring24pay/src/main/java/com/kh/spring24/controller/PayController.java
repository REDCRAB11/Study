package com.kh.spring24.controller;

import java.net.URISyntaxException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring24.entity.MemberDto;
import com.kh.spring24.entity.ProductDto;
import com.kh.spring24.repository.ProductDao;
import com.kh.spring24.service.KakaoPayService;
import com.kh.spring24.vo.KakaoPayApproveRequestVO;
import com.kh.spring24.vo.KakaoPayApproveResponseVO;
import com.kh.spring24.vo.KakaoPayOrderRequestVO;
import com.kh.spring24.vo.KakaoPayReadyRequestVO;
import com.kh.spring24.vo.KakaoPayReadyResponseVO;
import com.kh.spring24.vo.PurchaseItemVO;
import com.kh.spring24.vo.PurchaseVO;

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
	
	//결제 페이지 1번 - 입력창에 입력하면 결제되도록 구현
	@GetMapping("/pay1")
	public String pay1() {
		return "pay1";
	}
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@PostMapping("/pay1")
	public String pay1(
			@ModelAttribute KakaoPayReadyRequestVO vo,
			HttpSession session) throws URISyntaxException {
		String memberId = (String)session.getAttribute("loginId");
		vo.setPartner_user_id(memberId);
		vo.setPartner_order_id(UUID.randomUUID().toString());
		
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo);
		
		//4번 시점에서 9번 시점에 필요한 데이터를 세션에 저장
		session.setAttribute("tid", response.getTid());
		session.setAttribute("partner_order_id", vo.getPartner_order_id());
		session.setAttribute("partner_user_id", vo.getPartner_user_id());
		
		return "redirect:"+response.getNext_redirect_pc_url();
	}
	
	//결제 성공 시 자동 호출될 주소
	@GetMapping("/pay/result/success")
	public String paySuccess(
			HttpSession session, @RequestParam String pg_token) throws URISyntaxException {
		//9번 시점에서 4번 시점에서 세션에 저장한 데이터를 추출 및 삭제
		String tid = (String)session.getAttribute("tid");
		String partner_order_id = (String)session.getAttribute("partner_order_id");
		String partner_user_id = (String)session.getAttribute("partner_user_id");
		session.removeAttribute("tid");
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		
		KakaoPayApproveRequestVO vo = KakaoPayApproveRequestVO
				.builder()
				.tid(tid)
				.partner_order_id(partner_order_id)
				.partner_user_id(partner_user_id)
				.pg_token(pg_token)
				.build();
		KakaoPayApproveResponseVO response = kakaoPayService.approve(vo);
		return "redirect:/pay/result/success_view";
	}

	@GetMapping("/pay/result/success_view")
	public String successView() {
		return "success_view";
	}
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/pay2")
	public String pay2(Model model) {
		model.addAttribute("list", productDao.list());
		return "pay2";
	}
	
	@PostMapping("/pay2")
	public String pay2(HttpSession session, 
			@ModelAttribute PurchaseVO purchaseVO) throws URISyntaxException {
		//카카오페이에 보낼 정보를 계산
		//- 상품이 1개면 - 상품 이름이 결제 상품 명이고 결제 금액은 상품금액 * 수량
		//		- ex : 500원짜리 초코파이 3개를 사면 결제명="초코파이" 금액=1500 
		//- 상품이 여러개면 상품명은 첫 번째 상품명 외 ?개로 한다
		//		- ex : 500원짜리 초코파이2개와 300원짜리 마이쮸3개
		//		-> 상품명=초코파이 외 1개, 금액=1900
		if(purchaseVO.getData().isEmpty()) {
			return "redirect:pay2";
		}
		
		//첫 번째 상품만 따로 불러서 이름과 금액을 추출
		PurchaseItemVO firstVO = purchaseVO.getData().get(0);
		ProductDto firstProductDto = productDao.find(firstVO.getNo());
		String item_name = firstProductDto.getName();
		if(purchaseVO.getData().size() >= 2) {//상품이 2개 이상이면
			int value = purchaseVO.getData().size()-1;
			item_name += " 외 "+value+"개";
		}
		
		int total_amount = firstProductDto.getPrice() * firstVO.getQty();
		
		//두 번째 이후의 상품을 반복하여 합계를 합산
		for(int i=1; i < purchaseVO.getData().size(); i++) {//no, qty를 추출
			PurchaseItemVO itemVO = purchaseVO.getData().get(i);
			ProductDto productDto = productDao.find(itemVO.getNo());//상품정보 불러와서
			int total = productDto.getPrice() * itemVO.getQty();//상품 구매금액 계산
			total_amount += total;
		}
		
		KakaoPayReadyRequestVO vo = KakaoPayReadyRequestVO
				.builder()
				.partner_order_id(UUID.randomUUID().toString())
				.partner_user_id((String)session.getAttribute("loginId"))
				.item_name(item_name)
				.total_amount(total_amount)
				.build();
		
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo);
		
		//4번 시점에서 9번 시점에 필요한 데이터를 세션에 저장
		session.setAttribute("tid", response.getTid());
		session.setAttribute("partner_order_id", vo.getPartner_order_id());
		session.setAttribute("partner_user_id", vo.getPartner_user_id());
		
		return "redirect:"+response.getNext_redirect_pc_url();
	}
	
	//주문 조회 페이지
	@GetMapping("/detail")
	public String detail(@RequestParam String tid, Model model) throws URISyntaxException {
		KakaoPayOrderRequestVO vo = KakaoPayOrderRequestVO
				.builder().tid(tid).build();
		model.addAttribute("info", kakaoPayService.order(vo));
		return "detail";
	}
	
}








