package com.kh.springhome.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.BookDto;

@Repository
public class BookDaoImpl implements BookDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(BookDto dto) {
		String sql = "insert into book(book_serial, book_name, book_writer, book_publisher, book_price, book_genre,creation_time) values(book_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
		Object[] param = {
			dto.getName(), dto.getWriter(),
			dto.getPublisher(), dto.getPrice(),
			dto.getGenre()
		};
		jdbcTemplate.update(sql, param);
	}

	

}
	
