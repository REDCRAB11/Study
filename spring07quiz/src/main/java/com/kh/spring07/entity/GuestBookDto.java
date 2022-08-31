package com.kh.spring07.entity;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class GuestBookDto {
	private int no;
	private String name;
	private String memo;
	public GuestBookDto() {
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "GuestBookDto [no=" + no + ", name=" + name + ", memo=" + memo + "]";
	}
	
	private static RowMapper<GuestBookDto> mapper = (rs, idx)->{
		GuestBookDto dto = new GuestBookDto();
		dto.setNo(rs.getInt("no"));
		dto.setName(rs.getString("name"));
		dto.setMemo(rs.getString("memo"));
		return dto;
	};
	public static RowMapper<GuestBookDto> getMapper() {
		return mapper;
	}
	
private static ResultSetExtractor<GuestBookDto> extractor = (rs)->{
		if(rs.next()) {
			GuestBookDto dto = new GuestBookDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setMemo(rs.getString("memo"));
			return dto;
		}	else {
			return null;
		}
};
	public static ResultSetExtractor<GuestBookDto> getExtractor() {
		return extractor;
	}
}