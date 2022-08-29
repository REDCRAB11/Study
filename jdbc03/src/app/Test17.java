package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test17 {

	public static void main(String[] args) {
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "delete book where book_serial = ?";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 도서 번호 입력 : ");
		int bookSerial = sc.nextInt();
		sc.nextLine();
		
		Object[] param = new Object[] {bookSerial};
		
		int result = template.update(sql, param);
		if(result > 0) {
			System.out.println("도서 정보 삭제 완료");
		}
		else {
			System.out.println("해당 번호의 도서가 없습니다");
		}
		
		sc.close();
	}

}
