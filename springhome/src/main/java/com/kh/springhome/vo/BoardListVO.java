package com.kh.springhome.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BoardListVO {
	private int boardNo;
	private String boardHead, boardWriter, boardTitle;
	private Date boardWritetime;
	private int boardRead, boardLike;
	private int boardGroup, boardParent, boardDepth;
	private int replyCount;
}