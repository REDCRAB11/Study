package com.kh.spring24.service;

import java.net.URISyntaxException;

import com.kh.spring24.vo.KakaoPayApproveRequestVO;
import com.kh.spring24.vo.KakaoPayApproveResponseVO;
import com.kh.spring24.vo.KakaoPayOrderRequestVO;
import com.kh.spring24.vo.KakaoPayOrderResponseVO;
import com.kh.spring24.vo.KakaoPayReadyRequestVO;
import com.kh.spring24.vo.KakaoPayReadyResponseVO;

public interface KakaoPayService {
	KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO vo) throws URISyntaxException;
	KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO vo) throws URISyntaxException;
	KakaoPayOrderResponseVO order(KakaoPayOrderRequestVO vo) throws URISyntaxException;
}