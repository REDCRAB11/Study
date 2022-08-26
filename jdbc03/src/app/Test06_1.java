package app;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.MusicDto;
import util.JdbcUtil;

public class Test06_1 {
	public static void main(String[] args) {
//		app.Test06 : 사용자에게 검색어를 입력받아 제목, 가수, 앨범에 대한 유사검색을 수행한 뒤 결과를 구하여 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("검색어 입력: ");
		String keyword = sc.next();
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		

		String sql = "select * from music where instr(upper(music_title), upper(?)) > 0 "
							+ "union "
							+ "select * from music where instr(upper(music_artist), upper(?)) > 0 "
							+ "union "
							+ "select * from music where instr(upper(music_album), upper(?)) > 0";
		Object[] param = {keyword, keyword, keyword};
			
		RowMapper<MusicDto> mapper = (rs, idx) -> {
			MusicDto dto = new MusicDto();
			dto.setNo(rs.getInt("music_no"));
			dto.setTitle(rs.getString("music_title"));
			dto.setArtist(rs.getString("music_artist"));
			dto.setAlbum(rs.getString("music_album"));
			dto.setPlay(rs.getInt("music_play"));
			dto.setReleasetime(rs.getString("release_time"));
			return dto;
		};
		
		List<MusicDto> list = template.query(sql, mapper, param);
		System.out.println("결과: " + list.size());
		for(MusicDto dto : list) {
			System.out.println(dto);
		}
	}
}
