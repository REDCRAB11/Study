package com.kh.spring17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring17.entity.ProductDto;

@SpringBootTest
public class ProductSearchTest {

		@Autowired
		private SqlSession sqlSession;
		
//		@Test
		public void test() {
			//목록 
//			List<ProductDto> list = sqlSession.selectList("product.complex1");
			
			// 검색
//			Map<String, Object>param = new HashMap<>();
//			param.put("type", "name");
//			param.put("keyword", "바나나");
//			List<ProductDto> list = sqlSession.selectList("product.complex1", param);
			
			//복합검색
			Map<String, Object>param = new HashMap<>();
			
			//여기서 번호는 있을 수도, 없을 수도 있다. 
			param.put("no", 1); 
			//여기서 이름은 있을 수도 없을 수도 있다. 
			param.put("name", "스크류바");
			//여기서 가격은 있을 수도 없을 수도 있다. 
			param.put("minPrice", 500);
			//여기서 가격은 있을 수도 없을 수도 있다.
			param.put("maxPrice", 3000);
			//여기서 가격은 있을 수도 없을 수도 있다.
			param.put("beginMade", "2020-01-01");
			//여기서 가격은 있을 수도 없을 수도 있다.
			param.put("endMade", "2020-06-30");
//			param.put("type", List.of("과자"));
//			param.put("type", List.of("과자", "사탕"));
//			param.put("type", List.of("과자", "사탕", "주류"));
			param.put("type", List.of("과자", "사탕", "아이스크림", "주류"));
			List<ProductDto> list = sqlSession.selectList("product.complex4", param);
			
			for(ProductDto dto : list) {
				System.out.println(dto);
			}
		}
		
		@Test
		public void test2() {
			Map<String, Object>param = new HashMap<>();
			param.put("sort", List.of("price desc", "no asc"));
			List<ProductDto> list = sqlSession.selectList("product.complex6", param);
			
			for(ProductDto dto : list) {
				System.out.println(dto);
		}
		}
}
