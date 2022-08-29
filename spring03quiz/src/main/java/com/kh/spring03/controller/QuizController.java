package com.kh.spring03.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuizController {
	
	@RequestMapping("/bmi")
	@ResponseBody
	public String bmi(@RequestParam double height, double weight) {
		double heightMeter = height/100;
		double bmi = weight/(heightMeter*heightMeter);
		return "BMI:" +bmi;
	}
	
	
	@RequestMapping("/subway")
	@ResponseBody
	public String subway(@RequestParam int year ) {
		int birth = 20000101;
		int years = birth/10000;
		int nows = 2022; 
		int ages = nows - years +1;
		if(20 <= ages && ages < 65) {
			System.out.println("요금: 1250");
		//if(ages >= 20)
		}else if(14 <= ages && ages < 20) {
			System.out.println("요금: 720");
		//if(ages >= 14)
		}else if(8 <= ages && ages < 14) {
			System.out.println("요금: 450원");
		
		}else{ 
			System.out.println("요금: 0");
		}
		return "요금: " + year;
	}
	
	@RequestMapping("/calendar")
	@ResponseBody
	public String calendar(@RequestParam int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1); 
		
		int week = c.get(Calendar.DAY_OF_WEEK);
		
		c.add(Calendar.DATE, -(week-1));  
		
		for(int i=0; i<42; i++) {
			if(i % 7 ==6) {
			}
			c.add(Calendar.DATE, 1);
		}
		
		return "요일: " + year + month;
		
		
	}
	
}
