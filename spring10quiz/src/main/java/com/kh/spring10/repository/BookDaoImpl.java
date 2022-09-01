package com.kh.spring10.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.spring10.entity.BookDto;

import io.micrometer.core.instrument.MultiGauge.Row;

@Repository
public class BookDaoImpl implements BookDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(BookDto bookDto) {
		String sql = "insert into book("
							+ "book_serial, book_name, book_writer, "
							+ "book_publisher, book_price, book_genre,"
							+ "creation_time"
						+ ") values("
							+ "book_seq.nextval, ?, ?, ?, ?, ?, sysdate"
						+ ")";
		Object[] param = {
			bookDto.getName(), bookDto.getWriter(),
			bookDto.getPublisher(), bookDto.getPrice(),
			bookDto.getGenre()
		};
		jdbcTemplate.update(sql, param);
	}

	
	@Override
	public boolean update(BookDto bookDto) {
		String sql = "update "
						+ "set "
							+ "book_name=?, book_writer=?, book_publisher=?, "
							+ "book_genre=?, book_price=? "
						+ "where book_serial=?";
		Object[] param = {
			bookDto.getName(), bookDto.getWriter(),
			bookDto.getPublisher(), bookDto.getGenre(),
			bookDto.getPrice(), bookDto.getSerial()
		};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	@Override
	public boolean delete(int serial) {
		String sql = "delete book where book_serial=?";
		Object[] param = {serial};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	private RowMapper<BookDto> mapper = new RowMapper<BookDto>(){

		@Override
		public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookDto dto = new BookDto();
			dto.setSerial(rs.getInt("book_serial"));
			dto.setName(rs.getString("book_name"));
			dto.setWriter(rs.getString("book_writer"));
			dto.setPublisher(rs.getString("book_publisher"));
			dto.setPrice(rs.getInt("book_price"));
			dto.setGenre(rs.getString("book_genre"));
			dto.setCreationTime(rs.getDate("creation_time"));
			return dto;
		}
		
	};
	
	@Override
	public List<BookDto> selectList() {
		String sql = "select * from book order by book_serial asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
	@Override
	public List<BookDto> selectList(String genre, String keyword) {
		String sql = "select * from book where instr(#1,?)>0 order by #1 asc";
		sql = sql.replace("#1", genre);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	private ResultSetExtractor<BookDto> extractor = new ResultSetExtractor<BookDto>() {

		@Override
		public BookDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {			
			BookDto dto = new BookDto();
			dto.setSerial(rs.getInt("book_serial"));
			dto.setName(rs.getString("book_name"));
			dto.setWriter(rs.getString("book_writer"));
			dto.setPublisher(rs.getString("book_publisher"));
			dto.setPrice(rs.getInt("book_price"));
			dto.setGenre(rs.getString("book_genre"));
			dto.setCreationTime(rs.getDate("creation_time"));
			return dto;
				
			}else {
				return null;
			}
		}
	};
	
	@Override
	public BookDto selecOne(int serial) {
		String sql = "select * from book where book_serial =?";
		Object[] param = {serial};
		return jdbcTemplate.query(sql, extractor, param);
	}
}
	
