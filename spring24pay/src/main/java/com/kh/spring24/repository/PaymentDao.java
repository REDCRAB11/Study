package com.kh.spring24.repository;

import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;

public interface PaymentDao {
	int paymentSequence();
	void paymentInsert(PaymentDto paymentDto);
	
	int paymentDetailSequence();
	void paymentDetailInsert(PaymentDetailDto paymentDetailDto);
}