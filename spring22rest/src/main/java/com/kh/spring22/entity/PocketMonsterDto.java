package com.kh.spring22.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PocketMonsterDto {
	private int no;
	private String name;
	private String type;
}