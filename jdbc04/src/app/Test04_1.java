package app;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import book.util.JdbcUtil;
import dto.BookDto;

public class Test04_1 {
	public static void main(String[] args) {
		//사용자가 입력한 검색어에 해당하는 도서명/저자/출판사의 도서를 출력(셋 중 하나)
		
		//준비
		String keyword = "kh";
		
		//DB
		JdbcTemplate template = JdbcUtil.getTemplate();
		String sql = "select * from book "
							+ "where "
								+ "instr(upper(book_name), upper(?)) > 0 "
								+ "or instr(upper(book_writer), upper(?)) > 0 "
								+ "or instr(upper(book_publisher), upper(?)) > 0 "
							+ "order by book_serial asc";
		Object[] param = {keyword, keyword, keyword};
		
		List<BookDto> list = template.query(
											sql, BookDto.getMapper(), param);
		if(list.isEmpty()) {
			System.out.println("검색 결과가 존재하지 않습니다");
		}
		else {
			System.out.println(keyword+"에 대한 검색 결과 : " + list.size()+"개");
			for(BookDto bookDto : list) {
				System.out.println(bookDto);
			}
		}
	}
}
