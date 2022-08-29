package app;

import org.springframework.jdbc.core.JdbcTemplate;

import book.util.JdbcUtil;
import dto.BookDto;

public class Test05 {
	public static void main(String[] args) {
		//사용자가 입력한 번호에 해당하는 도서의 정보를 출력
		// - 단일 조회
		
		//준비
		int bookSerial = 1;
		
		//DB처리
		JdbcTemplate template = JdbcUtil.getTemplate();
		String sql = "select * from book where book_serial = ?";
		Object[] param = {bookSerial};
		
		BookDto bookDto = template.query(
										sql, BookDto.getExtractor(), param);
		if(bookDto == null) {
			System.out.println("존재하지 않는 도서 번호");
		}
		else {
			System.out.println(bookSerial + "번 도서 정보");
			System.out.println(bookDto);
		}
	}
}
