package com.kh.spring17.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring17.entity.ProductDto;
import com.kh.spring17.vo.ProductSearchVO;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ProductDto> complexSearch(ProductSearchVO vo) {
		return sqlSession.selectList("product.complex7", vo);
	}
}
