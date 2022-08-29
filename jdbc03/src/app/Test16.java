package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test16 {

	public static void main(String[] args) {

		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update book set book_price = ? where book_serial = ?";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("변경할 도서의 번호 : ");
		int bookSerial = sc.nextInt();
		sc.nextLine();
		System.out.print("변경값(가격) : ");
		long bookPrice = sc.nextLong();
		sc.nextLine();
		
		Object[] param = new Object[] {bookPrice, bookSerial};
		
		int result = template.update(sql, param);
		if(result > 0) {
			System.out.println("도서 가격 변경 완료");
		}
		else {
			System.out.println("해당 번호의 도서가 없습니다");
		}
		
		sc.close();
	}

}
