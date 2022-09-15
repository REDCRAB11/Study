package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.MusicDto;
import com.kh.springhome.vo.MusicYearCountVO;
import com.kh.springhome.vo.PocketMonsterCountVO;

@Repository
public class MusicDaoImpl  implements MusicDao{


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<MusicDto> mapper = new RowMapper<MusicDto>() {
		@Override
		public MusicDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MusicDto dto = new MusicDto();
			dto.setMusicNo(rs.getInt("music_no"));
			dto.setMusicTitle(rs.getString("music_title"));
			dto.setMusicArtist(rs.getString("music_artist"));
			dto.setMusicAlbum(rs.getString("music_album"));
			dto.setMusicPlay(rs.getInt("music_play"));
			dto.setReleaseTime(rs.getDate("release_time"));
			return dto;
		}
	};
	
	private ResultSetExtractor<MusicDto> extractor = new ResultSetExtractor<MusicDto>() {

		@Override
		public MusicDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				MusicDto dto = new MusicDto();
				dto.setMusicNo(rs.getInt("music_no"));
				dto.setMusicTitle(rs.getString("music_title"));
				dto.setMusicArtist(rs.getString("music_artist"));
				dto.setMusicAlbum(rs.getString("music_album"));
				dto.setMusicPlay(rs.getInt("music_play"));
				dto.setReleaseTime(rs.getDate("release_time"));
				return dto;
			}else {
				return null;
			}
		}
	};

	
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

	@Override
	public List<MusicDto> selectList() {
		String sql = " select * from music order by music_no asc";
				return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<MusicDto> selectList(String type, String keyword) {
		String sql = " select * from music where instr(#1, ?) > 0 order by  #1 asc";
//		String sql = " select * from music where instr("+type+", ?) >0 order by "+type+" asc";
//		Object [] param = {keyword};
		
		sql = sql.replace("#1", type);
		Object [] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}

	@Override
	public MusicDto selectOne(int musicNo) {
		String sql = "select * from music where music_no = ?";
		Object [] param = {musicNo};
		return jdbcTemplate.query(sql, extractor,param);
	}
	
	@Override
	public boolean update(MusicDto dto) {
		String sql = "update music set music_title=?, music_artist=?, music_album=?, music_play=?, release_time=? where music_no=?";
		Object[] param = { dto.getMusicTitle(), dto.getMusicArtist(), dto.getMusicAlbum(), dto.getMusicPlay(), dto.getReleaseTime(), dto.getMusicNo()};
		return jdbcTemplate.update(sql, param)>0;
	}

	@Override
	public boolean delete(int musicNo) {
		String sql = "delete music where music_no=?";
		Object[] param = {musicNo};
		return jdbcTemplate.update(sql, param) >0;
	}
	
	// 내가 푼거 밑에 오버라이드 두개 
	private RowMapper<MusicYearCountVO> countMapper = new RowMapper<MusicYearCountVO>() {
		@Override
		public MusicYearCountVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MusicYearCountVO vo = new MusicYearCountVO();
			vo.setPlay(rs.getString("play"));
			vo.setCnt(rs.getString("cnt"));
			return vo;
		}
	};

	@Override
	public List<MusicYearCountVO> selectCountList() {
		String sql = "select music_play,release_time from music where rownum <= 10 order by release_time desc";
		return jdbcTemplate.query(sql, countMapper);
	}// 여기까지 내가 품 

	@Override
	public List<MusicDto> top10() {
			String sql="select * from ( select TMP.*, rownum rn from ( select * from music order by music_play desc) TMP ) where rn between 1and 10";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<MusicDto> topN(int limit) {
		String sql="select * from ( select TMP.*, rownum rn from ( select * from music order by music_play desc) TMP ) where rn between 1and ?";
		Object[] param = {limit};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	
	
}
