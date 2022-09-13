package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String mg = (String) session.getAttribute("mg");
		boolean admin = mg != null && mg.equals("관리자");
		if(admin) {
			return true; 
		}else {
			response.sendError(403); // 사용자에게 권한없음(403) 전송 
//			response.sendError("/" ); // 메인으로 리다이렉트
			return false;
		}
	}
}
