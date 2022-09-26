package com.kh.springhome.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.MemberBoardLikeDto;

@Repository
public class MemberBoardLikeDaoImpl implements MemberBoardLikeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(MemberBoardLikeDto dto) {
		String sql = "insert into member_board_like"
							+ "(member_id, board_no) values(?, ?)";
		Object[] param = {dto.getMemberId(), dto.getBoardNo()};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public void delete(MemberBoardLikeDto dto) {
		String sql = "delete member_board_like "
						+ "where member_id = ? and board_no = ?";
		Object[] param = {dto.getMemberId(), dto.getBoardNo()};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public boolean check(MemberBoardLikeDto dto) {
		String sql = "select count(*) from member_board_like "
							+ "where member_id = ? and board_no = ?";
		Object[] param = {dto.getMemberId(), dto.getBoardNo()};
		int count = jdbcTemplate.queryForObject(sql, int.class, param);
		return count == 1;//좋아요 상태면 1 아니면 0
	}

	@Override
	public int count(int boardNo) {
		String sql = "select count(*) from member_board_like "
								+ "where board_no = ?";
		Object[] param = {boardNo};
		return jdbcTemplate.queryForObject(sql, int.class, param);
	}
	
	@Override
	public void refresh(int boardNo) {
		String sql = "update board set board_like = ("
							+ "select count(*) from member_board_like "
							+ "where board_no = ?"
						+ ") where board_no = ?";
		Object[] param = {boardNo, boardNo};
		jdbcTemplate.update(sql, param);
	}
}







