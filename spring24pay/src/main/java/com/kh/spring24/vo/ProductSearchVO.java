package com.kh.spring24.vo;

import java.util.List;

import lombok.Data;

//복합 검색용 VO
@Data
public class ProductSearchVO {
	private Integer no;
	private String name;
	private List<String> type;
	private Integer minPrice, maxPrice;
	private String beginMade, endMade;
	
	private List<String> sort;
}