package com.kh.spring24.repository;

import java.util.List;

import com.kh.spring24.entity.ProductDto;

public interface ProductDao {
	List<ProductDto> list();
	ProductDto find(int no);
}