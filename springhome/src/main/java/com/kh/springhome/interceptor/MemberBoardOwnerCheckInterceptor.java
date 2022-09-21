package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.springhome.constant.SessionConstant;
import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.repository.BoardDao;

@Component
public class MemberBoardOwnerCheckInterceptor  implements HandlerInterceptor{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//통과할 만한 상황이란?
		// (1) 현재 사용자가 작성자인 경우 
		// (2) 관리자가 삭제하는 경우 
		
		// (1)
		HttpSession session = request.getSession();
//		String memberId = (String)session.getAttribute("loginId");
		String memberId = (String)session.getAttribute(SessionConstant.ID);
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardDto boardDto = boardDao.selectOne(boardNo);
		boolean isOwner = memberId.equals(boardDto.getBoardWriter());
		if(isOwner) {//소유자라면 통과 
			return true;
		}
		
		//(2)
//		String memberGrade = (String)session.getAttribute("mg");
		String memberGrade = (String)session.getAttribute(SessionConstant.GRADE);
		boolean isAdmin = memberGrade.equals("관리자");
		boolean isDelete = request.getRequestURI().equals("/board/eidt");
		System.out.println("uri="+ request.getRequestURI());
		if(isAdmin && isDelete) {//관리자라면 통과 
			return true;
		}
		
		// 기본적으로 차단 
		response.sendError(403);
		return false;
	}
}
