package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.MusicDto;
import util.JdbcUtil;

public class Test05 {
	public static void main(String[] args) {
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql="select * from music order by music_play desc, music_no asc ";
		
		RowMapper<MusicDto> mapper = new RowMapper<MusicDto>() {

			@Override
			public MusicDto mapRow(ResultSet rs, int idx) throws SQLException {
				MusicDto dto = new MusicDto();
				dto.setNo(rs.getInt("music_no"));
				dto.setTitle(rs.getString("music_title"));
				dto.setArtist(rs.getString("music_artist"));
				dto.setAlbum(rs.getString("music_album"));
				dto.setPlay(rs.getInt("music_play"));
				dto.setReleasetime(rs.getString("release_time"));
				return dto;
			}
			
		};
		
		List<MusicDto> list = template.query(sql, mapper);
		for(MusicDto dto : list) {
			System.out.println(dto);
//			System.out.print(dto.getNo()+ "\t");
//			System.out.print(dto.getTitle()+ "\t");
//			System.out.print(dto.getArtist()+ "\t");
//			System.out.print(dto.getAlbum()+ "\t");
//			System.out.print(dto.getPlay()+ "\t");
//			System.out.print(dto.getReleasetime() + "\t");
//			System.out.println();
		}
	}
}
