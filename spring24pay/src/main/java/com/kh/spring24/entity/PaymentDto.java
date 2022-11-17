package com.kh.spring24.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PaymentDto {
	private int paymentNo;
	private String memberId;
	private String itemName;
	private int totalAmount;
	private Date approveAt;
	private String paymentStatus;
	private String tid;
}