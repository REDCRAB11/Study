package com.kh.spring17.repository;

import java.util.List;

import com.kh.spring17.entity.ProductDto;
import com.kh.spring17.vo.ProductSearchVO;

public interface ProductDao {

	List<ProductDto> complexSearch(ProductSearchVO vo);
}
