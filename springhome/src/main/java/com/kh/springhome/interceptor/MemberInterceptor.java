package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 인터셉터(Interceptor)
// - 서버의 처리 과정에 개입해서 원하는 방향의 작업을 추가하는 도구
// - 간섭 객체 
// - 특정 인터페이스를 상속받아서 자격을 획득한다.(HandlerInterceptor) 
// - 간섭 시점에 따라 원하는 메소드를 재정의하여 사용 (Source -> override and implements 들어가면 됨) 
//		- 작업 시작 전(preHandle)
// 	- 작업  중(postHandel)
// 	- 작업 종료 후 (afterCompletion)

// 이 클래스의 목적은 회원이 아닌 존재가 회원 기능에 접근하는 것을 차단. 
@Component// 단일 기능을 수행하는 도구 
public class MemberInterceptor implements HandlerInterceptor{

//	preHadle에서 true/false를 반환하면 통과/차단이 가능 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("member interceptor");
		return true;// or false 
	}
	
}