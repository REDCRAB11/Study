package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring11.entity.PocketMonsterDto;

//pocket_monster 테이블에 대한 CRUD처리를 위한 컨트롤러 
@Controller
@RequestMapping("pocket-monster")
public class PocketMonsterController {
	
	//JDBC를 위해서 이미 설정으로 만들어둔 JdbcTemplate을 가져온다. 
	// - 만드는 것이 아니라 	Spring에게 "주세요!" 해야한다. 
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestParam int no,
										@RequestParam String name,
										@RequestParam String type) {
		String sql = "insert into pocket_monster(no,name,type) values(?,?,?)";
		Object[] param = {no, name, type};
		jdbcTemplate.update(sql, param);
		return "등록 완료.";
	}
	
	// 번호를 이용해서 이름과 유형을 변경 
	@RequestMapping("/update")
	@ResponseBody
	public String update(@RequestParam int no, @RequestParam String name, @RequestParam String type) {
		String sql = "update pocket_monster set name=?, type=? where no=?";
		Object[] param = {name, type, no};
		int result=	jdbcTemplate.update(sql, param);
		if( result > 0) {
			return "수정 완료.";
		} else{
			return "없는 번호.";
		}
	}
	
	//삭제 
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int no) {
		String sql = "delete pocket_monster where no =?";
		Object[] param = {no};
		int result = jdbcTemplate.update(sql,param);
		if(result > 0) {
			return "삭제 완료.";
		}else {
			return "없는 번호.";
		}
	}
	
	
	// 목록 or 검색 -> RowMapper<PocketMonsterDto>
	@RequestMapping("/select")
	@ResponseBody
	public String select() {
		String sql= "select * from pocket_monster order by no asc";
		List<PocketMonsterDto> list = jdbcTemplate.query(sql, PocketMonsterDto.getMapper());
		StringBuffer buffer = new StringBuffer();
		for(PocketMonsterDto dto : list) {
			buffer.append(dto);
			buffer.append("<br>");
		}
		return list.toString();
	}
	
	
	// 상세 -> ResultSetExtractor<PocketMonsterDto>
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int no) {
		String sql = "select * from pocket_monster where no=?";
		Object[] param = {no};
		PocketMonsterDto dto = jdbcTemplate.query(sql, PocketMonsterDto.getExtractor(),param);
		if(dto == null) {
			return "없는 번호";
		}else {
			return dto.toString();
		}
	}
	
}
