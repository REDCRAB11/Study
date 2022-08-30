package com.kh.spring04.controller;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/sum")
	@ResponseBody
	public String sum(@RequestParam int begin,@RequestParam int end) {
		int total = 0;
		for(int i = begin; i <= end; i++) {
			total += i;
		}
		return "합계: ";
		
	}
	
//	@RequestMapping("/gugudan")
//	@ResponseBody
//	public String gugudan(@RequestParam int num) {
//		Random r = new Random();
//		int gu = r.nextInt(8)+2;
//		int dan = r.nextInt(9)+1;
//		
//		for(int i=1; i<=num; i++) {
//			num++;
//		}
//		return "구구단 랜덤  시작!   " +  gu +" * "+  dan + " = " + (gu*dan);
//	}
	
	
	@RequestMapping("/gugudan")
	@ResponseBody
	public String gugudan(@RequestParam int count) {
		StringBuffer buffer = new StringBuffer();
		Random r = new Random();
		for(int i=0; i < count; i++) {
			int a = r.nextInt(8) +2;
			int b = r.nextInt(9)+1;
			buffer.append(a);
			buffer.append(" * " );
			buffer.append(b);
			buffer.append(" = ");
			buffer.append("<br>");
		}
//		String text = "";
//		반복되는데 스트링에는 + 기호를 쓸 수 없다. 
//		text += "?x? =";
//		text += "<br>"; 
		return buffer.toString();
	}
	
	
	// 파라미터가 같은 이름으로 여러개 존재하는 경우 
	// - >  배열 혹은 collection으로 처리 
//	@RequestMapping("/total")
//	@ResponseBody
//	public String total(@RequestParam int number[]) {
//		int total = 0;
//		for(int i = 0; i < number.length; i++) {
//			total += number[i];
//		}
//		return "합계 : " + total;
//		
//	}

	@RequestMapping("/total")
	@ResponseBody
	public String tota(@RequestParam int[] v) {
	 	int value = 0;
	for(int n : v) {
		value += n;
	}
	return "합계; " +value;
//	얘도 되고 밑에도 되고..
	
//	public String total(@RequestParam List<Integer> v) {
//	System.out.println(v);
//	return "합계 : " + v;
//	}
	
}
}
