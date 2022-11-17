package com.kh.spring24;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring24.service.KakaoPayService;
import com.kh.spring24.vo.KakaoPayReadyRequestVO;
import com.kh.spring24.vo.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PayTest03 {
	
	@Autowired
	private KakaoPayService kakaoPayService;

	@Test
	public void test() throws URISyntaxException {
		//결제에 필요한 데이터를 준비
		KakaoPayReadyRequestVO request = 
				KakaoPayReadyRequestVO.builder()
					.partner_order_id(UUID.randomUUID().toString())
					.partner_user_id(UUID.randomUUID().toString())
					.item_name("갤럭시폴드4")
					.total_amount(990000)
				.build();
		log.debug("partner_order_id = {}", request.getPartner_order_id());
		log.debug("partner_user_id = {}", request.getPartner_user_id());
		
		KakaoPayReadyResponseVO response = 
								kakaoPayService.ready(request);
		log.debug("response = {}", response);
		log.debug("url = {}", response.getNext_redirect_pc_url());
		log.debug("tid = {}", response.getTid());
	}
	
}
