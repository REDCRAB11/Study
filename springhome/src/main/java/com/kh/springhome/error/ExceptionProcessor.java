package com.kh.springhome.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 컨트롤러 어드바이스는 컨트롤러의 오류를 간섭하는 객체
//@ControllerAdvice(annotations = {Controller.class}) annotation으로 임포트 
@ControllerAdvice(basePackages= {"com.kh.springhome.controller"})
public class ExceptionProcessor {
	// 원하는 상황이 발생하면 자동으로 간섭하여 실행할 메소드 
	// - 메소드는 컨트롤러와 동일한 구성이 가능(+예외 객체 선언 가능)  
	// - 반환 시 view resolver의 영향을 받는다 
	@ExceptionHandler(Exception.class)	
	public String handle(Exception e ) {
		return "error/exception";
	}
	
	@ExceptionHandler(TargetNotFoundException.class)
	public String handle2(Exception e) {
		return"error/notfound";
	}
	
}
