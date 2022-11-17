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

import com.kh.spring24.configuration.KakaoPayProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PayTest02 {
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;

	@Test
	public void test() throws URISyntaxException {
		//결제에 필요한 데이터를 준비
		String partner_order_id = UUID.randomUUID().toString();
		String partner_user_id = UUID.randomUUID().toString();
		String item_name = "강남아파트 1채";
		int total_amount = 470000;
		
		//카카오 페이 서버로 요청을 전송할 도구 필요
		RestTemplate template = new RestTemplate();
		
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("partner_order_id", partner_order_id);//주문번호
		body.add("partner_user_id", partner_user_id);//고객번호
		body.add("item_name", item_name);//판매할 상품명
		body.add("quantity", "1");//판매할 상품명
		body.add("total_amount", String.valueOf(total_amount));//구매금액
		body.add("tax_free_amount", "0");//비과세(0원)
		body.add("approval_url", "http://localhost:8888/pay/result/success");//성공 시 실행될 주소
		body.add("cancel_url", "http://localhost:8888/pay/result/cancel");//취소 시 실행될 주소
		body.add("fail_url", "http://localhost:8888/pay/result/fail");//실패 시 실행될 주소
		
		//보낼 내용 합체
		HttpEntity<MultiValueMap<String, String>> entity = 
											new HttpEntity<>(body, headers);
		
		//요청
		Map response = template.postForObject(uri, entity, Map.class);
		log.debug("response = {}", response);
	}
	
}
