package com.kh.spring04.quiz;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	// a ~ b 의 합 
	@RequestMapping("/sum")
	@ResponseBody
	public String sum(@RequestParam int begin,@RequestParam int end) {
		
		int s = 0; 
		for(int i = begin; i <= end ; i++) {
				s += i;
		}
		return "합계: " + s;
		
	}
	
	@RequestMapping("/gugudan")
	@ResponseBody
	public String gugudan(@RequestParam int num) {
		Random r = new Random();
		int gu = r.nextInt(8)+2;
		int dan = r.nextInt(9)+1;
		
		for(int i=1; i<=num; i++) {
			num++;
		}
		return "구구단 랜덤  시작!   " +  gu +" * "+  dan + " = " + (gu*dan);
	}
	
	@RequestMapping("/total")
	@ResponseBody
	public String total(@RequestParam int number[]) {
		int total = 0;
		for(int i = 0; i < number.length; i++) {
			total += number[i];
		}
		return "합계 : " + total;
		
	}

}
