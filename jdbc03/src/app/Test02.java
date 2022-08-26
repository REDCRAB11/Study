package app;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test02 {
	public static void main(String[] args) {
		
		
		
		String music_title = "사랑은 참 어려워";
		String music_artist = "nct-dream";
		String music_album = "BOOM";
		
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
