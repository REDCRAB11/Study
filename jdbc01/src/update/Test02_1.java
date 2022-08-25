package update;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test02_1 {
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update guest_book set name = ?, memo = ? where no = ?";
		System.out.println("입력: ");
		Object[] param = {sc.next(), sc.next(), sc.nextInt()};
		
		int result = template.update(sql,param);
		
//		System.out.println(result);
		
		if(result > 0) {
			System.out.println("변경 완료");
		}else {
			System.out.println("해당하는 번호가 없습니다.");
		}
				
	}

}
