package com.kh.springhome.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberListForMainVO {
	private String memberId, memberNick;
	private String memberGrade;
	private int cnt, rank;
}