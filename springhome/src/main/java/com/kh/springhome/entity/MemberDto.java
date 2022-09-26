package com.kh.springhome.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberDto {
	private String memberId, memberPw;
	private String memberNick, memberTel, memberEmail;
	private String memberPost, memberBaseAddress, memberDetailAddress;
	private int memberPoint;
	private String memberGrade;
	private Date memberBirth, memberJoin, memberLogin;
}