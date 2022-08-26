package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test02_1 {
	public static void main(String[] args) {
// 문제에 없다고 해도 필요하면 추가로 해야한다 ~ music_no<- 이거 ㅋㅋ 
		// 정보변경 
		Scanner sc = new Scanner(System.in);
		System.out.println("번호: ");
		int music_no = sc.nextInt();
		System.out.println("타이틀: ");
		String music_title = sc.next();
		System.out.println("가수: ");
		String music_artist = sc.next();
		System.out.println("앨범: ");
		String music_album = sc.next();
		sc.close();
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update music set music_title=?, music_artist=?, music_album=? where music_no=?";
		Object[] param = {music_title, music_artist, music_album, music_no};
		
		int result = template.update(sql,param);
		
		if(result > 0) {
			System.out.println("변경 완료");
		}else {
			System.out.println("변경 불가");
		}
				
	}
}
