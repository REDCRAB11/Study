package com.kh.springhome.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class MypageListDto {
	private String memberId, memberNick, memberGrade;
	private String boardWriter, boardTitle, boardContent;
	private int boardNo, boardRead;
	private Date boardWritetime;
	
}
