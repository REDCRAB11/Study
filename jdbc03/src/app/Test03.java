package app;


import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import util.JdbcUtil;

public class Test03 {
	public static void main(String[] args) {
		//app.Test03 : 사용자에게 음원번호를 입력받아 해당하는 음원번호의 재생 수를 1 증가시키는 프로그램을 구현

		Scanner sc = new Scanner(System.in);
		System.out.println("번호입력: ");
		int music_no = sc.nextInt();
		int music_play = +1;
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update music set music_no=? where music_play=?";
		Object[] param = {music_no,music_play};
		
		int result = template.update(sql,param);
		System.out.println("result: " + result);
		
		if(result > 0) {
			System.out.println("변경 완료");
		}else {
			System.out.println("변경 불가");
		}
	}
}
