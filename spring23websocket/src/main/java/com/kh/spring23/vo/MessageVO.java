package com.kh.spring23.vo;
//서버에서 클라이언트와 소통하기 위한 JSON처리용 VO
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties// 이걸 추가해야 데이터가 없어도 변환해준다.
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MessageVO {
	private String text; // 클라이언트가 보내는 정보 
	private Date time; // 서버가 추가해야할 정보 
}
