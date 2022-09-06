package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.GuestBookDto;

@Repository
public class GuestBookDaoImpl implements GuestBookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<GuestBookDto> mapper = new RowMapper<GuestBookDto>() {
		@Override
		public GuestBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			GuestBookDto dto = new GuestBookDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setMemo(rs.getString("memo"));
			return dto;
		}
	};
	
	@Override
	public void insert(GuestBookDto dto) {
		String sql = "insert into guest_book(no, name, memo) "
								+ "values(guest_book_seq.nextval, ?, ?)";
		Object[] param = {dto.getName(), dto.getMemo()};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<GuestBookDto> selectList() {
		String sql = "select * from guest_book order by no desc";
				return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<GuestBookDto> selectList(String type, String keyword) {
		String sql = "select * from guest_book where instr(#1,?)>0 order by #1 asc";
		sql = sql.replace("#1", type);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}

}