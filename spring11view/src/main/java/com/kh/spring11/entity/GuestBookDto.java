

package com.kh.spring11.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class GuestBookDto {
	private int no;
	private String name;
	private String memo;
	public GuestBookDto() {
		super();
	}
	@Override
	public String toString() {
		return "GuestBookDto [no=" + no + ", name=" + name + ", memo=" + memo + "]";
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
	
	private static RowMapper<GuestBookDto> mapper = new RowMapper<GuestBookDto>() {
		@Override
		public GuestBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			GuestBookDto dto = new GuestBookDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setMemo(rs.getString("memo"));
			return dto;
		}
	};
	private static ResultSetExtractor<GuestBookDto> extractor = new ResultSetExtractor<GuestBookDto>() {
		@Override
		public GuestBookDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				GuestBookDto dto = new GuestBookDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setMemo(rs.getString("memo"));
				return dto;
			}
			else {
				return null;
			}
		}
	};
	
	public static RowMapper<GuestBookDto> getMapper() {
		return mapper;
	}
	public static ResultSetExtractor<GuestBookDto> getExtractor() {
		return extractor;
	}
}

