package com.kh.springhome.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.MusicDto;

@Repository
public class MusicDaoImpl  implements MusicDao{


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(MusicDto dto) {
		String sql = "insert into music("
				+ "music_no, music_title, music_artist, "
				+ "music_album, music_play, release_time) "
			+ "values(music_seq.nextval, ?, ?, ?, 0 ,?)";
		Object[] param = {
				dto.getMusicTitle(), dto.getMusicArtist(),
				dto.getMusicAlbum(), dto.getReleaseTime()
		};
jdbcTemplate.update(sql, param);
	}

	
}
