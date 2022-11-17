package com.kh.spring24.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//카카오페이 준비 요청에 필요한 데이터
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaoPayReadyRequestVO {
	private String partner_order_id;
	private String partner_user_id;
	private String item_name;
	private int total_amount;
}