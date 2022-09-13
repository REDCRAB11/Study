package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TestInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, // 사용자 요청 정보 
			HttpServletResponse response, // 사용자 응답 정보 
			Object handler // 실행될 컨트롤러 메소드 객체(검사용) 
			)
			throws Exception {
		System.out.println("preHandle");
		System.out.println("-> handler = " + handler);
		return true;
	}
	
	
	//컨트롤러 작업 후 뷰 생성 전 시점 
	@Override
	public void postHandle(HttpServletRequest request, // 사용자 요청 정보 
			HttpServletResponse response, // 사용자 응답 정보 
			Object handler, //처리한 컨트롤러 메소드 정보 
			ModelAndView modelAndView // 모델과 뷰 정보 
			) throws Exception {
		System.out.println("postHandle");
		System.out.println("-> handler = " + handler);
		System.out.println(" -> m&v " + modelAndView);
	}
	
	// 화면(view) 생성 후 시점을 간섭 
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			Exception ex
			)
			throws Exception {
		System.out.println("afterCompletion");
		System.out.println("-> excep = " + ex);
		if(ex != null) {// 처리 과정에서 예외가 생겼다면 
			
		}
	}
}