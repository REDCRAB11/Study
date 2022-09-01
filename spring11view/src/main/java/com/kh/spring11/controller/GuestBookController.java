
		package com.kh.spring11.controller;


		import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring11.entity.GuestBookDto;

		@Controller
		@RequestMapping("/guest-book")
		public class GuestBookController {
			
//			참고 : @ModelAttribute는 객체의 필드에 자동 매핑을 수행한다
			
			@Autowired
			private JdbcTemplate jdbcTemplate;
			
			@RequestMapping("/insert")
			@ResponseBody
//			public String insert(@RequestParam String name, @RequestParam String memo) {
			public String insert(@ModelAttribute GuestBookDto dto) {
				String sql = "insert into guest_book(no, name, memo) "
									+ "values(guest_book_seq.nextval, ?, ?)";
				Object[] param = {dto.getName(), dto.getMemo()};
				jdbcTemplate.update(sql, param);
				return "등록 완료!";
			}
			
			@RequestMapping("/update")
			@ResponseBody
			public String update(@ModelAttribute GuestBookDto dto) {
				String sql = "update guest_book set name=?, memo=? where no=?";
				Object[] param = {dto.getName(), dto.getMemo(), dto.getNo()};
				int result = jdbcTemplate.update(sql, param);
				if(result > 0) {
					return "수정 성공";
				}
				else {
					return "존재하지 않는 번호";
				}
			}
			
			@RequestMapping("/delete")
			@ResponseBody
			public String delete(@RequestParam int no) {
				String sql = "delete guest_book where no = ?";
				Object[] param = {no};
				int result = jdbcTemplate.update(sql, param);
				if(result > 0) {
					return "삭제 완료";
				}
				else {
					return "존재하지 않는 번호";
				}
			}

			@RequestMapping("/list")
			@ResponseBody
			public String list() {
				String sql = "select * from guest_book order by no asc";
				List<GuestBookDto> data = 
						jdbcTemplate.query(sql, GuestBookDto.getMapper());
				
				StringBuffer buffer = new StringBuffer();
				for(GuestBookDto dto : data) {
					buffer.append(dto);
					buffer.append("<br>");
				}
				return buffer.toString();
			}
			
			@RequestMapping("/detail")
			@ResponseBody
			public String detail(@RequestParam int no) {
				String sql = "select * from guest_book where no = ?";
				Object[] param = {no};
				
				GuestBookDto dto = 
						jdbcTemplate.query(sql, GuestBookDto.getExtractor(), param);
//						jdbcTemplate.query(sql, param, GuestBookDto.getExtractor());
				
				if(dto == null) {
					return "없는 번호";
				}
				else {
					return dto.toString();
				}
			}
			
//			사용자가 원하는 항목을 type이라는 이름으로 전송하면 해당 항목을 검색
			@RequestMapping("/search")
			@ResponseBody
			public String search(
					@RequestParam String type,
					@RequestParam String keyword) {
				if(type.equals("name")) {
					String sql = "select * from guest_book where instr(name, ?) > 0 order by no asc";
					Object[] param = {keyword};
					List<GuestBookDto> data = 
						jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
					
					StringBuffer buffer = new StringBuffer();
					for(GuestBookDto dto : data) {
						buffer.append(dto);
						buffer.append("<br>");
					}
					return buffer.toString();
				}
				else if(type.equals("memo")) {
					String sql = "select * from guest_book where instr(memo, ?) > 0 order by no asc";
					Object[] param = {keyword};
					List<GuestBookDto> data = 
						jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
					
					StringBuffer buffer = new StringBuffer();
					for(GuestBookDto dto : data) {
						buffer.append(dto);
						buffer.append("<br>");
					}
					return buffer.toString();
				}
				else {
					return "잘못된 검색";
				}
			}
			
			@RequestMapping("/search2")
			@ResponseBody
			public String search2(
					@RequestParam String type,
					@RequestParam String keyword) {
				String sql;
				if(type.equals("name")) {
					sql = "select * from guest_book where instr(name, ?) > 0 order by no asc";
				}
				else {
					sql = "select * from guest_book where instr(memo, ?) > 0 order by no asc";
				}
				
				Object[] param = {keyword};
				List<GuestBookDto> data = 
					jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
				
				StringBuffer buffer = new StringBuffer();
				for(GuestBookDto dto : data) {
					buffer.append(dto);
					buffer.append("<br>");
				}
				return buffer.toString();
			}
			
			@RequestMapping("/search3")
			@ResponseBody
			public String search3(
					@RequestParam String type,
					@RequestParam String keyword) {
				String sql = "select * from guest_book "
									+ "where instr("+type+", ?) > 0 order by no asc";
				Object[] param = {keyword};
				List<GuestBookDto> data = 
					jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
				
				StringBuffer buffer = new StringBuffer();
				for(GuestBookDto dto : data) {
					buffer.append(dto);
					buffer.append("<br>");
				}
				return buffer.toString();
			}
			
			@RequestMapping("/search4")
			@ResponseBody
			public String search4(
					@RequestParam String type,
					@RequestParam String keyword) {
				String sql = "select * from guest_book "
									+ "where instr(#1, ?) > 0 order by no asc";
				sql = sql.replace("#1", type);
				Object[] param = {keyword};
				List<GuestBookDto> data = 
					jdbcTemplate.query(sql, GuestBookDto.getMapper(), param);
				
				StringBuffer buffer = new StringBuffer();
				for(GuestBookDto dto : data) {
					buffer.append(dto);
					buffer.append("<br>");
				}
				return buffer.toString();
			}
}
