package com.kh.springhome.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ReplyListVO {
	private int replyNo, replyOrigin;
	private String replyWriter, replyContent;
	private Date replyWritetime;
	private boolean replyBlind;
	private String memberNick, memberGrade;
}