package com.kh.spring02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 컨트롤러는 주소만 겹치지 않는다면 여러 개 만들 수 있다. 
@Controller
public class ParamControlloer {
		
	//요청  파라미터(Request Parameter)
	// - 사용자가 주소에 첨부하는 데이터 
	// - 쿼리 스트링(query string)이라고도 부름 
	// - 주소 뒤에 물음표 (?)를 찍고 key=value 형태로 첨부 
	
	// ex, http://localhost:8888/age?year=2000
	// 파라미터 이름이 year이고 value가 2000이다.
	// 매개변수 앞에 @RequestParam이라고 적으면 파라미터를 읽는 변수 
	@RequestMapping("/age")
	@ResponseBody
	public String age(@RequestParam int year) {
		int age = 2022 - year +1;
		return "나이: " + age;
	}
	
}
