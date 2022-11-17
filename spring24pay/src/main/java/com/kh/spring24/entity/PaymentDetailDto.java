package com.kh.spring24.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PaymentDetailDto {
	private int paymentDetailNo;
	private int paymentNo;
	private int productNo;
	private String productName;
	private int qty;
	private int productPrice;
	private String paymentDetailStatus;
}