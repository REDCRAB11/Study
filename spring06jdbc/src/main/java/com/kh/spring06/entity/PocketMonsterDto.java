package com.kh.spring06.entity;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class PocketMonsterDto {
	//field - 컬럼과 동일하게
	private int no;
	private String name;
	private String type;
	public PocketMonsterDto() {
		super();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PocketMonsterDto [no=" + no + ", name=" + name + ", type=" + type + "]";
	}
	
	//RowMapper - 목록
	private static RowMapper<PocketMonsterDto> mapper = (rs, idx)->{
		PocketMonsterDto dto = new PocketMonsterDto();
		dto.setNo(rs.getInt("no"));
		dto.setName(rs.getString("name"));
		dto.setType(rs.getString("type"));
		return dto;
	};
	public static RowMapper<PocketMonsterDto> getMapper() {
		return mapper;
	}
	
	//ResultSetExtractor - 객체
	private static ResultSetExtractor<PocketMonsterDto> extractor = (rs)->{
		if(rs.next()) {
			PocketMonsterDto dto = new PocketMonsterDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setType(rs.getString("type"));
			return dto;
		}
		else {
			return null;
		}
	};
	public static ResultSetExtractor<PocketMonsterDto> getExtractor() {
		return extractor;
	}
	
}