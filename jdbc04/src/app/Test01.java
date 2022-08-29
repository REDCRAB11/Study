package app;

import org.springframework.jdbc.core.JdbcTemplate;

import book.util.JdbcUtil;

public class Test01 {
	public static void main(String[] args) {
		//사용자에게 필요한 정보를 입력받아 도서를 등록
		//필요한 정보 - 도서명, 저자, 출판사, 판매가, 장르
		
		//준비
		String bookName = "자바마스터";
		String bookWriter = "열혈강사";
		String bookPublisher = "KH정보교육원";
		int bookPrice = 15000;
		String bookGenre = "IT";
		
		//처리
		JdbcTemplate template = JdbcUtil.getTemplate();
		String sql = "insert into book("
							+ "book_serial, book_name, book_writer, "
							+ "book_publisher, book_price, "
							+ "book_genre, creation_time"
						+ ") "
						+ "values(book_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
		Object[] param = {bookName, bookWriter, bookPublisher, bookPrice, bookGenre};
		template.update(sql, param);
		
		System.out.println("등록 완료");
	}
}
