package com.kh.spring24.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring24.configuration.KakaoPayProperties;
import com.kh.spring24.vo.KakaoPayApproveRequestVO;
import com.kh.spring24.vo.KakaoPayApproveResponseVO;
import com.kh.spring24.vo.KakaoPayOrderRequestVO;
import com.kh.spring24.vo.KakaoPayOrderResponseVO;
import com.kh.spring24.vo.KakaoPayReadyRequestVO;
import com.kh.spring24.vo.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaoPayServiceImpl implements KakaoPayService{
	
	private RestTemplate template = new RestTemplate();
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	@Override
	public KakaoPayReadyResponseVO ready(
									KakaoPayReadyRequestVO vo) throws URISyntaxException {
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("partner_order_id", vo.getPartner_order_id());//주문번호
		body.add("partner_user_id", vo.getPartner_user_id());//고객번호
		body.add("item_name", vo.getItem_name());//판매할 상품명
		body.add("quantity", "1");//판매할 상품명
		body.add("total_amount", String.valueOf(vo.getTotal_amount()));//구매금액
		body.add("tax_free_amount", "0");//비과세(0원)
		body.add("approval_url", "http://localhost:8888/pay/result/success");//성공 시 실행될 주소
		body.add("cancel_url", "http://localhost:8888/pay/result/cancel");//취소 시 실행될 주소
		body.add("fail_url", "http://localhost:8888/pay/result/fail");//실패 시 실행될 주소
		
		//보낼 내용 합체
		HttpEntity<MultiValueMap<String, String>> entity = 
											new HttpEntity<>(body, headers);
		
		//요청
		KakaoPayReadyResponseVO response = template.postForObject(
				uri, entity, KakaoPayReadyResponseVO.class);
		
		return response;
	}
	
	@Override
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO vo) throws URISyntaxException {
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("tid", vo.getTid());//거래번호
		body.add("partner_order_id", vo.getPartner_order_id());//주문번호
		body.add("partner_user_id", vo.getPartner_user_id());//고객번호
		body.add("pg_token", vo.getPg_token());//인증용 토큰
		
		log.debug("partner_order_id = {}", vo.getPartner_order_id());
		log.debug("partner_user_id = {}", vo.getPartner_user_id());
		log.debug("tid = {}", vo.getTid());
		log.debug("pg_token = {}", vo.getPg_token());
		
		//보낼 내용 합체
		HttpEntity<MultiValueMap<String, String>> entity = 
											new HttpEntity<>(body, headers);
		
		//요청
		KakaoPayApproveResponseVO response = 
				template.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
		return response;
	}
	
	@Override
	public KakaoPayOrderResponseVO order(KakaoPayOrderRequestVO vo) throws URISyntaxException {
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("tid", vo.getTid());
		
		//보낼 내용 합체
		HttpEntity<MultiValueMap<String, String>> entity = 
											new HttpEntity<>(body, headers);
		
		//요청
		KakaoPayOrderResponseVO response = 
				template.postForObject(uri, entity, KakaoPayOrderResponseVO.class);
		return response;
	}
	
}
