package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public boolean preHandle(HttpServletRequest request, // 요청 정보가 담긴 객체 
			HttpServletResponse response, // 응답 정보가 담긴 객체 
			Object handler // 이 요청을 실행할 매핑(메소드) 정보 
			)
			throws Exception {
			// 시나리오 
		// 1. 접속한 사용자가 로그인 상태인지 검사(request 객체 필요) 
		// - HttpSession에 loginId란 값이 있는지 검사 
		// 2. 상태에 따라 통과/차단 설정
		// (1) 로그인 상태라면 통과 (return true)
		// (2) 로그인 상태가 아니라면 로그인 페이지로 리다이렉트 후 차단 
		
		
		// 1 . 세션이 없을 때는 HttpServletRequest에서 획득 가능 
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		if(loginId == null) {// 비회원 2-(2)
			
			// 선택지는 2가지 있다. 
			
			// [1]  로그인 페이지로 리다이렉트
			response.sendRedirect("/member/login");
			
			// [2] HTTP 상태 코드 중에서 미인증(401)을 반환 
			// - 추가로 상태번호에 따른 처리가 필요하다 . 
//			response.sendError(401);
			
			return false; //차단 
		}else {// 회원 2-(1)
			return true; //통과
		}
	}
}