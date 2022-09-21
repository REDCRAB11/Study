package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.ReplyDto;

@Repository
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private ResultSetExtractor<ReplyDto> extractor = new ResultSetExtractor<ReplyDto>() {
		@Override
		public ReplyDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				return ReplyDto.builder()
						.replyNo(rs.getInt("reply_no"))
						.replyWriter(rs.getString("reply_writer"))
						.replyOrigin(rs.getInt("reply_origin"))
						.replyWritetime(rs.getDate("reply_writetime"))
						.replyContent(rs.getString("reply_content"))
						.build();
			}else {
				return null;
			}
		}
	};
	
	
	@Override
	public void insert(ReplyDto replyDto) {
		String sql = "insert into reply(reply_no, reply_writer, reply_origin, reply_content) "
															+ "value(reply_seq.nextval, ?, ?, ?)";
		Object[] param = {replyDto.getReplyWriter(), replyDto.getReplyOrigin(), replyDto.getReplyContent()};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public boolean update(ReplyDto replyDto) {
		String sql = "update reply set reply_content =? reply_writetime = sysdate where reply_no=?";
		Object [] param = {replyDto.getReplyContent(), replyDto.getReplyWritetime(), replyDto.getReplyNo()};
		return jdbcTemplate.update(sql, param) >0;
	}

	@Override
	public ReplyDto selectOne(int replyNo) {
		String sql = "select * from reply where reply_no =?";
		Object[] param  = {replyNo};
		return jdbcTemplate.query(sql, extractor, param);
	}
}
