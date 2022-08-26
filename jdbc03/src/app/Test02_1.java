package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test02_1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("타이틀: ");
		String music_title = sc.next();
		System.out.println("가수: ");
		String music_artist = sc.next();
		System.out.println("앨범: ");
		String music_album = sc.next();
		sc.close();
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update music set music_title=?, music_artist=?, music_album=?";
		Object[] param = {music_title, music_artist, music_album};
		
		int result = template.update(sql,param);
		
		if(result > 0) {
			System.out.println("변경 완료");
		}else {
			System.out.println("변경 불가");
		}
				
	}
}
