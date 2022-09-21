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
import com.kh.springhome.vo.BoardListSearchVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(BoardDto boardDto) {
		String sql = "insert into board("
							+ "board_no, board_title, board_writer,"
							+ "board_content, board_head"
						+ ") values(board_seq.nextval, ?, ?, ?, ?)";
		Object[] param = {
			boardDto.getBoardTitle(), boardDto.getBoardWriter(),
			boardDto.getBoardContent(), boardDto.getBoardHead()
		};
		jdbcTemplate.update(sql, param);
	}
	
	@Override
	public void clear() {
		String sql = "delete board";
		jdbcTemplate.update(sql);
	}
	
	private RowMapper<BoardDto> mapper = new RowMapper<BoardDto>() {
		@Override
		public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return BoardDto.builder()
							.boardNo(rs.getInt("board_no"))
							.boardTitle(rs.getString("board_title"))
							.boardContent(rs.getString("board_content"))
							.boardWriter(rs.getString("board_writer"))
							.boardHead(rs.getString("board_head"))
							.boardRead(rs.getInt("board_read"))
							.boardLike(rs.getInt("board_like"))
							.boardWritetime(rs.getDate("board_writetime"))
							.boardUpdatetime(rs.getDate("board_updatetime"))
							.boardGroup(rs.getInt("board_group"))
							.boardParent(rs.getInt("board_parent"))
							.boardDepth(rs.getInt("board_depth"))
						.build();
		}
	};

	@Override
	public List<BoardDto> selectList() {
		String sql = "select * from board order by board_no desc";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<BoardDto> selectList(BoardListSearchVO vo) {
		if(vo.isSearch()) {//검색이라면
			return search(vo);
		}
		else {//목록이라면
			return list(vo);
		}
	}
	
	private ResultSetExtractor<BoardDto> extractor = new ResultSetExtractor<BoardDto>() {
		@Override
		public BoardDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				return BoardDto.builder()
						.boardNo(rs.getInt("board_no"))
						.boardTitle(rs.getString("board_title"))
						.boardContent(rs.getString("board_content"))
						.boardWriter(rs.getString("board_writer"))
						.boardHead(rs.getString("board_head"))
						.boardRead(rs.getInt("board_read"))
						.boardLike(rs.getInt("board_like"))
						.boardWritetime(rs.getDate("board_writetime"))
						.boardUpdatetime(rs.getDate("board_updatetime"))
						.boardGroup(rs.getInt("board_group"))
						.boardParent(rs.getInt("board_parent"))
						.boardDepth(rs.getInt("board_depth"))
					.build();
			}
			else {
				return null;
			}
		}
	};
	
	@Override
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no = ?";
		Object[] param = {boardNo};
		return jdbcTemplate.query(sql, extractor, param);
	}
	
	@Override
	public boolean updateReadcount(int boardNo) {
		String sql = "update board "
						+ "set board_read = board_read + 1 "
						+ "where board_no = ?";
		Object[] param = {boardNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	@Override
	public BoardDto read(int boardNo) {
		this.updateReadcount(boardNo);
		return this.selectOne(boardNo);
	}
	
	@Override
	public int sequence() {
		String sql = "select board_seq.nextval from dual";
		int boardNo = jdbcTemplate.queryForObject(sql, int.class);
		return boardNo;
	}
	
	@Override
	public void insert2(BoardDto boardDto) {
		String sql = "insert into board("
					+ "board_no, board_title, board_content,"
					+ "board_writer, board_head, "
					+ "board_group, board_parent, board_depth"
				+ ") values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = {
			boardDto.getBoardNo(), boardDto.getBoardTitle(),
			boardDto.getBoardContent(), boardDto.getBoardWriter(),
			boardDto.getBoardHead(), boardDto.getBoardGroup(),
			boardDto.getBoardParentInteger(), boardDto.getBoardDepth()
		};
		jdbcTemplate.update(sql, param);
	}
	
	@Override
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no = ?";
		Object[] param = {boardNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	@Override
	public boolean update(BoardDto boardDto) {
		String sql = "update board "
						+ "set "
							+ "board_title=?, "
							+ "board_content=?, "
							+ "board_head=?, "
							+ "board_updatetime=sysdate "
						+ "where board_no = ?";
		Object[] param = {
			boardDto.getBoardTitle(), boardDto.getBoardContent(),
			boardDto.getBoardHead(), boardDto.getBoardNo()
		};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	@Override
	public List<BoardDto> search(BoardListSearchVO vo) {
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from board "
								+ "where instr(#1, ?) > 0 "
								+ "connect by prior board_no=board_parent "
								+ "start with board_parent is null "
								+ "order siblings by board_group desc, board_no asc "
							+ ")TMP"
						+ ") where rn between ? and ?";
		sql = sql.replace("#1", vo.getType());
		Object[] param = {
			vo.getKeyword(), vo.startRow(), vo.endRow()
		};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	@Override
	public List<BoardDto> list(BoardListSearchVO vo) {
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from board "
								+ "connect by prior board_no=board_parent "
								+ "start with board_parent is null "
								+ "order siblings by board_group desc, board_no asc "
							+ ")TMP"
						+ ") where rn between ? and ?";
		Object[] param = {vo.startRow(), vo.endRow()};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	@Override
	public int count(BoardListSearchVO vo) {
		if(vo.isSearch()) {
			return searchCount(vo);
		}
		else {
			return listCount(vo);
		}
	}
	
	@Override
	public int listCount(BoardListSearchVO vo) {
		String sql = "select count(*) from board";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	@Override
	public int searchCount(BoardListSearchVO vo) {
		String sql = "select count(*) from board "
						+ "where instr(#1, ?) > 0";
		sql = sql.replace("#1", vo.getType());
		Object[] param = {vo.getKeyword()};
		return jdbcTemplate.queryForObject(sql, int.class, param);
	}
}
