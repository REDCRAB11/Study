package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.ReplyDto;
import com.kh.springhome.vo.ReplyListVO;

@Repository
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<ReplyDto> mapper = new RowMapper<ReplyDto>() {
		@Override
		public ReplyDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return ReplyDto.builder()
							.replyNo(rs.getInt("reply_no"))
							.replyWriter(rs.getString("reply_writer"))
							.replyContent(rs.getString("reply_content"))
							.replyOrigin(rs.getInt("reply_origin"))
							.replyWritetime(rs.getDate("reply_writetime"))
							.replyBlind(rs.getString("reply_blind") != null)
						.build();
		}
	};
	
	private RowMapper<ReplyListVO> listMapper = new RowMapper<ReplyListVO>() {
		@Override
		public ReplyListVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return ReplyListVO.builder()
							.replyNo(rs.getInt("reply_no"))
							.replyWriter(rs.getString("reply_writer"))
							.replyContent(rs.getString("reply_content"))
							.replyOrigin(rs.getInt("reply_origin"))
							.replyWritetime(rs.getDate("reply_writetime"))
							.replyBlind(rs.getString("reply_blind") != null)
							.memberNick(rs.getString("member_nick"))
							.memberGrade(rs.getString("member_grade"))
						.build();
		}
	};

	@Override
	public void insert(ReplyDto replyDto) {
		String sql = "insert into reply("
							+ "reply_no, reply_content,"
							+ "reply_writer, reply_origin"
						+ ")"
						+ "values(reply_seq.nextval, ?, ?, ?)";
		Object[] param = {
			replyDto.getReplyContent(), replyDto.getReplyWriter(),
			replyDto.getReplyOrigin()
		};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<ReplyListVO> selectList(int replyOrigin) {
		String sql = "select R.*, M.member_nick, M.member_grade "
						+ "from reply R left outer join member M "
							+ "on R.reply_writer = M.member_id "
						+ "where reply_origin = ? "
						+ "order by reply_no asc";
		Object[] param = {replyOrigin};
		return jdbcTemplate.query(sql, listMapper, param);
	}

	@Override
	public boolean update(ReplyDto replyDto) {
		String sql = "update reply "
						+ "set reply_content=? "
						+ "where reply_no=?";
		Object[] param = {
			replyDto.getReplyContent(), replyDto.getReplyNo()
		};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public boolean delete(int replyNo) {
		String sql = "delete reply where reply_no = ?";
		Object[] param = {replyNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	private ResultSetExtractor<ReplyDto> extractor = new ResultSetExtractor<ReplyDto>() {
		@Override
		public ReplyDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				return ReplyDto.builder()
						.replyNo(rs.getInt("reply_no"))
						.replyWriter(rs.getString("reply_writer"))
						.replyContent(rs.getString("reply_content"))
						.replyOrigin(rs.getInt("reply_origin"))
						.replyWritetime(rs.getDate("reply_writetime"))
						.replyBlind(rs.getString("reply_blind") != null)
					.build();
			}
			else {
				return null;
			}
		}
	};
	
	@Override
	public ReplyDto selectOne(int replyNo) {
		String sql = "select * from reply where reply_no = ?";
		Object[] param = {replyNo};
		return jdbcTemplate.query(sql, extractor, param);
	}
	
	@Override
	public boolean updateBlind(int replyNo, boolean blind) {
		String sql = "update reply "
						+ "set reply_blind = ? "
						+ "where reply_no = ?";
		String replyBlind = blind ? "Y" : null;//삼항연산
		//if(blind) {replyBlind = "Y";}else {replyBlind=null;}
		Object[] param = {replyBlind, replyNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
}




