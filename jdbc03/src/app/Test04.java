package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test04 {
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("삭제할 번호: ");
			int music_no = sc.nextInt();
			sc.close();
			
			JdbcTemplate template = JdbcUtil.getTemplate();
			
			String sql = "delete music where music_no =?";
			Object[] param = {music_no};
			
			int result = template.update(sql, param);
			if(result > 0) {
				System.out.println("삭제 완료!");
			}else {
				System.out.println("삭제 불가!");
			}
	}
}
