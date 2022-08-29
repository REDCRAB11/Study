package dto;

import java.sql.Date;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class BookDto {
	private int bookSerial;
	private String bookName;
	private String bookWriter;
	private String bookPublisher;
	private int bookPrice;
	private String bookGenre;
	private Date creationTime;
	public int getBookSerial() {
		return bookSerial;
	}
	public void setBookSerial(int bookSerial) {
		this.bookSerial = bookSerial;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public BookDto() {
		super();
	}
	@Override
	public String toString() {
		return "BookDto [bookSerial=" + bookSerial + ", bookName=" + bookName + ", bookWriter=" + bookWriter
				+ ", bookPublisher=" + bookPublisher + ", bookPrice=" + bookPrice + ", bookGenre=" + bookGenre
				+ ", creationTime=" + creationTime + "]";
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	//자주 사용하는 도구(ex : RowMapper, ResultSetExtractor)를 생성
	private static RowMapper<BookDto> mapper = (rs, idx)->{
		BookDto bookDto = new BookDto();
		bookDto.setBookSerial(rs.getInt("book_serial"));
		bookDto.setBookName(rs.getString("book_name"));
		bookDto.setBookWriter(rs.getString("book_writer"));
		bookDto.setBookPublisher(rs.getString("book_publisher"));
		bookDto.setBookPrice(rs.getInt("book_price"));
		bookDto.setBookGenre(rs.getString("book_genre"));
		bookDto.setCreationTime(rs.getDate("creation_time"));
		return bookDto;
	};
	public static RowMapper<BookDto> getMapper() {
		return mapper;
	}
	
	private static ResultSetExtractor<BookDto> extractor = (rs)->{
		if(rs.next()) {//데이터가 있으면 목록때처럼 복사
			BookDto bookDto = new BookDto();
			bookDto.setBookSerial(rs.getInt("book_serial"));
			bookDto.setBookName(rs.getString("book_name"));
			bookDto.setBookWriter(rs.getString("book_writer"));
			bookDto.setBookPublisher(rs.getString("book_publisher"));
			bookDto.setBookPrice(rs.getInt("book_price"));
			bookDto.setBookGenre(rs.getString("book_genre"));
			bookDto.setCreationTime(rs.getDate("creation_time"));
			return bookDto;
		}
		else {//데이터가 없으면 null을 반환
			return null;
		}
	};
	public static ResultSetExtractor<BookDto> getExtractor() {
		return extractor;
	}
}
