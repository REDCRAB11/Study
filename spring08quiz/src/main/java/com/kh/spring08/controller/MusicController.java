package com.kh.spring08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring08.entity.MusicDto;

@Controller
@RequestMapping("/music")
public class MusicController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	(주의)
//	파라미터로 전달 가능한 데이터는 String 뿐이다
//	하지만 특별히 원시형과 배열(리스트)까지는 자동 변환을 해준다
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute MusicDto musicDto) {
		String sql = "insert into music("
							+ "music_no, music_title, music_artist, "
							+ "music_album, music_play, release_time) "
						+ "values(music_seq.nextval, ?, ?, ?, 0, ?)";
		Object[] param = {
			musicDto.getMusicTitle(), musicDto.getMusicArtist(),
			musicDto.getMusicAlbum(), musicDto.getReleaseTime()
		};
		jdbcTemplate.update(sql, param);
		return "등록 완료";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(@ModelAttribute MusicDto musicDto) {
		String sql = "update music "
						+ "set "
							+ "music_title=?, "
							+ "music_artist=?, "
							+ "music_album=?, "
							+ "release_time=? "
						+ "where music_no=?";
		Object[] param = {
			musicDto.getMusicTitle(), musicDto.getMusicArtist(),
			musicDto.getMusicAlbum(), musicDto.getReleaseTime(),
			musicDto.getMusicNo()
		};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "수정 완료";
		}
		else {
			return "없는 번호";
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int musicNo) {
		String sql = "delete music where music_no=?";
		Object[] param = {musicNo};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "삭제 완료";
		}
		else {
			return "없는 번호";
		}
	}
	
//	경로 변수 방식
	@RequestMapping("/delete/{musicNo}")
	@ResponseBody
	public String delete2(@PathVariable int musicNo) {
		String sql = "delete music where music_no=?";
		Object[] param = {musicNo};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "삭제 완료";
		}
		else {
			return "없는 번호";
		}
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String list() {
		String sql = "select * from music order by music_no asc";
		List<MusicDto> data = 
						jdbcTemplate.query(sql, MusicDto.getMapper());
		
		StringBuffer buffer = new StringBuffer();
		for(MusicDto musicDto : data) {
			buffer.append(musicDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	//제목,가수,앨범 중 검색
	@RequestMapping("/search1")
	@ResponseBody
	public String search1(@RequestParam String keyword) {
		String sql = "select * from music "
						+ "where instr(music_title, ?) > 0 "
							+ "or where instr(music_artist, ?) > 0 "
							+ "or where instr(music_album, ?) > 0 "
						+ "order by music_no asc";
		Object[] param = {keyword, keyword, keyword};
		List<MusicDto> data = 
				jdbcTemplate.query(sql, MusicDto.getMapper(), param);
		
		StringBuffer buffer = new StringBuffer();
		for(MusicDto musicDto : data) {
			buffer.append(musicDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	@RequestMapping("/search2")
	@ResponseBody
	public String search2(
			@RequestParam String type, 
			@RequestParam String keyword) {
		String sql = "select * from music where instr(#1, ?) > 0 "
															+ "order by #1 asc";
		sql = sql.replace("#1", type);
		Object[] param = {keyword};
		List<MusicDto> data = 
				jdbcTemplate.query(sql, MusicDto.getMapper(), param);
		
		StringBuffer buffer = new StringBuffer();
		for(MusicDto musicDto : data) {
			buffer.append(musicDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	@RequestMapping("/detail/{musicNo}")
	@ResponseBody
	public String detail2(@PathVariable int musicNo) {
		String sql = "select * from music where music_no = ?";
		Object[] param = {musicNo};
		MusicDto musicDto = jdbcTemplate.query(
								sql, MusicDto.getExtractor(), param);
		if(musicDto == null) {
			return "없는 번호";
		}
		else {
			return musicDto.toString();
		}
	}
	
	
}
