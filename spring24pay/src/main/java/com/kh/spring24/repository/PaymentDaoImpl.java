package com.kh.spring24.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;

@Repository
public class PaymentDaoImpl implements PaymentDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int paymentSequence() {
		return sqlSession.selectOne("payment.paymentSequence");
	}
	@Override
	public void paymentInsert(PaymentDto paymentDto) {
		sqlSession.insert("payment.paymentInsert", paymentDto);
	}
	@Override
	public int paymentDetailSequence() {
		return sqlSession.selectOne("payment.paymentDetailSequence");
	}
	@Override
	public void paymentDetailInsert(PaymentDetailDto paymentDetailDto) {
		sqlSession.insert("payment.paymentDetailInsert", paymentDetailDto);
	}

}