package com.kh.spring24.vo;

import java.sql.Date;

import lombok.Data;

//카카오페이 준비 요청 결과 데이터
@Data
public class KakaoPayReadyResponseVO {
	private String tid;
	private String next_redirect_mobile_url;
	private String next_redirect_pc_url;
	private Date created_at;
}
