package delete;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("번호: "); 
		int no = sc.nextInt();
		sc.close();
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "delete guest_book where no =?";
//		System.out.println("입력:");
//		Object [] param = { sc.next() }; 이렇게 사용하는 경우에는 복잡해진다 ~
		Object [] param = {no};

		
		int result = template.update(sql,param);
		
		if(result > 0 ) {
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("존재하지 않는 번호 입니다.");
		}
	}
}
