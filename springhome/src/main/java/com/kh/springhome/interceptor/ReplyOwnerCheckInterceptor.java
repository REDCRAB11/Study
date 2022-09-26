package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.springhome.constant.SessionConstant;
import com.kh.springhome.entity.ReplyDto;
import com.kh.springhome.repository.ReplyDao;

@Component
public class ReplyOwnerCheckInterceptor implements HandlerInterceptor {

	@Autowired
	private ReplyDao replyDao;

	@Override// 접근 차단 프리핸들 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//검사할 항목
		// 1. 해당 댓글의 작성자가 현재 사용자일 경우 통과
		//2. 1번 검사에 detail 페이지에서 온 경우인지 추가로 검사 후 통과 
		//준비물: HttpSession, replyNo파라미터, referer헤더 
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute(SessionConstant.ID);
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String referer = request.getHeader("Referer");
		ReplyDto replyDto = replyDao.selectOne(replyNo);
		
		if(memberId.equals(replyDto.getReplyWriter())) { //1
			if(referer != null && referer.contains("/board/detail"));
			return true;
		}else {
			response.sendError(403);
			return false;
		}
	}
	
}
