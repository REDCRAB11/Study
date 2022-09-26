package com.kh.springhome.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class MyPageListVO {

		private String boardTitle, boardWirter;
		private Date boardWritetitme, boardRead;
		private String memberNick, memberId;
}
