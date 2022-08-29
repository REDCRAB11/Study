package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import util.JdbcUtil;

public class Test13 {

	public static void main(String[] args) {
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "select * from book where instr(book_name, ?) > 0 or instr(book_writer, ?) > 0 or instr(book_publisher, ?) > 0";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어 입력 : ");
		String keyword = sc.nextLine();
		
		Object[] param = new Object[] {keyword, keyword, keyword};
		
		RowMapper<BookDto> mapper = new RowMapper<BookDto>() {
			@Override
			public BookDto mapRow(ResultSet rs, int idx) throws SQLException {
				BookDto bookDto = new BookDto();
				bookDto.setBookSerial(rs.getInt("book_serial"));
				bookDto.setBookName(rs.getString("book_name"));
				bookDto.setBookWriter(rs.getString("book_writer"));
				bookDto.setBookPublisher(rs.getString("book_publisher"));
				bookDto.setBookPrice(rs.getInt("book_price"));
				bookDto.setCreationTime(rs.getString("creation_time"));
				return bookDto;
			}
		};
		
		List<BookDto> list = template.query(sql, mapper, param);
		
		for(BookDto bookDto : list) {
			System.out.println(bookDto);
		}
		
		sc.close();
	}

}
