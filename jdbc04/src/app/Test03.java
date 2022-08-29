package app;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import book.util.JdbcUtil;
import dto.BookDto;

public class Test03 {
	public static void main(String[] args) {
		//사용자가 입력한 검색어에 해당하는 장르의 도서를 출력
		//-> 일치 검색으로 처리
		
		//준비
		String bookGenre = "it";
		
		//DB
		JdbcTemplate template = JdbcUtil.getTemplate();
		String sql = "select * from book "
							//+ "where book_genre = ? "
							+ "where upper(book_genre) = upper(?) "
							+ "order by book_serial asc";
		Object[] param = {bookGenre};
		
		List<BookDto> list = template.query(
											sql, BookDto.getMapper(), param);
		if(list.isEmpty()) {
			System.out.println("검색 결과가 존재하지 않습니다");
		}
		else {
			System.out.println("\""+bookGenre+"\" 에 대한 검색 결과 : "+list.size()+"개");
			for(BookDto bookDto : list) {
				System.out.println(bookDto);
			}
		}
	}
}
