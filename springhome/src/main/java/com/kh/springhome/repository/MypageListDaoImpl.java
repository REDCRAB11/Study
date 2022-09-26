package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.MypageListDto;

@Repository
public class MypageListDaoImpl implements MypageListDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private ResultSetExtractor<MypageListDto> extractor = new ResultSetExtractor<MypageListDto>() {

		@Override
		public MypageListDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				return MypageListDto.builder()
						.memberId(rs.getString("member_id"))
						.memberNick(rs.getString("member_nick"))
						.boardNo(rs.getInt("board_no"))
						.boardTitle(rs.getString("board_title"))
						.boardWriter(rs.getString("board_writer"))
						.boardContent(rs.getString("board_content"))
						.boardRead(rs.getInt("board_read"))
						.boardWritetime(rs.getDate("board_writetime"))
						.build();
			}else {
				return null;
			}
		}
	};
	
	
	@Override
	public MypageListDto selectOne(MypageListDto dto) {
		String sql  = "select"
				+ "B.*, M.member_nick"
				+ "from board B left outer join member M on B.board_writer = M.member_id";
		Object[] param = {dto.getMemberNick(), dto.getBoardWriter(), dto.getMemberId()};
		return jdbcTemplate.query(sql, extractor, param);
	}
	
//	@Override
//	public List<MypageListDto> selectLisct() {
//		String sql  = "select"
//				+ "B.*, M.member_nick"
//				+ "from board B left outer join member M on B.board_writer = M.member_id";
//		Object[] param = {dto.getMemberNick(), dto.getBoardWriter(), dto.getMemberId()};
//		return jdbcTemplate.query(sql, extractor, param);
//	}
	
}
