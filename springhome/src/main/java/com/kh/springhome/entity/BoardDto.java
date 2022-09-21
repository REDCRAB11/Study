package com.kh.springhome.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BoardDto {
	private int boardNo;
	private String boardHead, boardWriter, boardTitle, boardContent;
	private Date boardWritetime, boardUpdatetime;
	private int boardRead, boardLike;
	//계층형 게시판 데이터
	//(참고) boardParent는 null일 수 있지만 JDBC에서 0으로 변환
	private int boardGroup, boardParent, boardDepth;
	
	//DB에 INSERT 할 때 0 대신 null이 등록되도록 값을 변환해서 반환하는 메소드
	public Integer getBoardParentInteger() {
		if(boardParent == 0) 
			return null;
		else 
			return boardParent;
	}
}


