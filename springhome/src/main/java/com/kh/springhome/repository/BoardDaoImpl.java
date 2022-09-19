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

import com.kh.springhome.entity.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<BoardDto> mapper = new RowMapper<BoardDto>() {

		@Override
		public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardDto dto = new BoardDto();
			dto.setBoardNo(rs.getInt("board_no"));
			dto.setBoardWriter(rs.getString("board_writer"));
			dto.setBoardTitle(rs.getString("board_title"));
			dto.setBoardContent(rs.getString("board_content"));
			dto.setBoardWriteTime(rs.getDate("board_writeTime"));
			dto.setBoardUpdateTime(rs.getDate("board_updateTime"));
			dto.setBoardRead(rs.getInt("board_read"));
			dto.setBoardLike(rs.getInt("board_like"));
			dto.setBoardHead(rs.getString("board_head"));
			return dto;
		}
	};
	
	private ResultSetExtractor<BoardDto> extractor = new ResultSetExtractor<BoardDto>() {

		public BoardDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setBoardNo(rs.getInt("board_no"));
				dto.setBoardWriter(rs.getString("board_writer"));
				dto.setBoardTitle(rs.getString("board_title"));
				dto.setBoardContent(rs.getString("board_content"));
				dto.setBoardWriteTime(rs.getDate("board_writeTime"));
				dto.setBoardUpdateTime(rs.getDate("board_updateTime"));
				dto.setBoardRead(rs.getInt("board_read"));
				dto.setBoardLike(rs.getInt("board_like"));
				dto.setBoardHead(rs.getString("board_head"));
				return dto;
			}else {
				return null;
			}
		}
	};
	
	
//	@Override
//	public void write(BoardDto boardDto) {
//		String sql ="insert into board(board_no, board_writer, board_title, board_content, board_writetime, board_updatetitme, board_read, board_like, board_head) "
//									+"values(board_seq.nextval, ? ,?, ?, sysdate, sysdate, 0, 0, ?)";
//		Object[] param = {boardDto.getBoardWriter(), boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardWriteTime(), boardDto.getBoardUpdateTime(), boardDto.getBoardRead(), boardDto.getBoardLike(), boardDto.getBoardHead()};
//		jdbcTemplate.update(sql, param);
//	}

	@Override
	public void write(BoardDto boardDto) {
		String sql ="insert into board(board_no, board_writer, board_title, board_content, board_head,  board_writetime)"
										+"values(board_seq.nextval, ? ,?, ?, ?, sysdate)";
		Object[] param = {boardDto.getBoardWriter(), boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardHead()};
		jdbcTemplate.update(sql, param);
	}


	@Override
	public List<BoardDto> selectList() {
		String sql="select * from board order by board_no asc";
		return jdbcTemplate.query(sql, mapper);
	}


	@Override
	public BoardDto selectOne(String boardWriter) {
		String sql = "select * from board where board_writer = ?";
		Object[] param = {boardWriter};
		return jdbcTemplate.query(sql, extractor, param);
	}
	
	
	@Override
	public BoardDto selectOne(int boardNo) {
		String sql ="select * from board where board_no=?";
		Object[] param = {boardNo};
		return jdbcTemplate.query(sql, extractor, param);
	}


	@Override
	public boolean delete(String boardWriter) {
		String sql= "delete board where board_writer = ?";
		Object[] param = {boardWriter};
		return jdbcTemplate.update(sql, param)>0;
	}


	@Override
	public boolean update(BoardDto dto) {
		String sql = "update board set board_title=?, board_content=?, board_head=? where board_writer=?";
		Object[] param = {dto.getBoardTitle(), dto.getBoardContent(), dto.getBoardHead(), dto.getBoardWriter()};
		return  jdbcTemplate.update(sql, param)>0 ;
	}


	@Override
	public List<BoardDto> selectList(String type, String keyword) {
		String sql = "select * from board where instr("+type+", ?) >0 order by +type+ asc";
		Object [] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}





		
	

}
