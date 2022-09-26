package com.kh.springhome.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PocketMonsterDto {
	//field - 컬럼과 동일하게
	private int no;
	private String name;
	private String type;
	private static ResultSetExtractor<PocketMonsterDto> extractor = new ResultSetExtractor<PocketMonsterDto>() {
		@Override
		public PocketMonsterDto extractData(ResultSet rs) throws SQLException, DataAccessException {
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
		}
	};
	public static ResultSetExtractor<PocketMonsterDto> getExtractor() {
		return extractor;
	}
	
}








