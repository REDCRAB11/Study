package com.kh.spring24;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring24.service.KakaoPayService;
import com.kh.spring24.vo.KakaoPayApproveRequestVO;
import com.kh.spring24.vo.KakaoPayApproveResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PayTest05 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		KakaoPayApproveRequestVO vo = KakaoPayApproveRequestVO
				.builder()
				.tid("T37587e47c755d997616")
				.partner_order_id("b0e2ab3e-33c0-440d-9f30-013456acd677")
				.partner_user_id("fd3d68b1-6da3-41fc-a650-caade248ad4a")
				.pg_token("d5040fea9776dc818d9d")
				.build();
		
		KakaoPayApproveResponseVO response = kakaoPayService.approve(vo);
		log.debug("response = {}", response);
	}
	
}