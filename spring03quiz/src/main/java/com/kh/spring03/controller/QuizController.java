package com.kh.spring03.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 주소 전체에 물음표는 딱 하나만 가능 
@Controller
@RequestMapping("/quiz") // 공용 주소 
public class QuizController {
	
	
	@RequestMapping("/bmi") 
	@ResponseBody
	public String bmi(@RequestParam double cm,
									@RequestParam double kg) {
		double m = cm/100;
		double bmi = kg/(m*m);
		Format f = new DecimalFormat("#,##0.00");
		return "BMI:" +f.format(bmi);
	}
	
	
	@RequestMapping("/subway")
	@ResponseBody
	public String subway(@RequestParam int year ) {
		int age = Calendar.getInstance().get(Calendar.YEAR) - year +1; 
		int price;
		if(20 <= age && age < 65) {
			price = 1250;
		}else if(14 <= age && age < 20) {
			price = 720;
		}else if(8 <= age && age < 14) {
			price = 450;
		}else{ 
			price =0;
		}
		return "요금: " + price;
	}
	
	@RequestMapping("/calendar") // 실제주소 : /quiz/calendar
	@ResponseBody
	public String calendar(@RequestParam int year, 
											@RequestParam int month) {
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1); 

		int max = c.getActualMaximum(Calendar.DATE);
		
		return year + "년 " + month + "월" + max + "일까지 있습니다.";
		
		
	}
	
}
