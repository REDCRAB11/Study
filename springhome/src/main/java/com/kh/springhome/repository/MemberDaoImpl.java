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

import com.kh.springhome.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<MemberDto> mapper = new RowMapper<MemberDto>() {
		@Override
		public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberDto dto = new MemberDto();
			dto.setMemberId(rs.getString("member_id"));
			dto.setMemberPw(rs.getString("member_pw"));
			dto.setMemberNick(rs.getString("member_nick"));
			dto.setMemberBirth(rs.getDate("member_birth"));
			dto.setMemberTel(rs.getString("member_tel"));
			dto.setMemberEmail(rs.getString("member_email"));
			dto.setMemberPost(rs.getString("member_post"));
			dto.setMemberBaseAddress(rs.getString("member_base_address"));
			dto.setMemberDetailAddress(rs.getString("member_detail_address"));
			dto.setMemberPoint(rs.getInt("member_point"));
			dto.setMemberGrade(rs.getString("member_grade"));
			dto.setMemberJoin(rs.getDate("member_join"));
			dto.setMemberLogin(rs.getDate("member_login"));
			return dto;
		}
	};
	
	private ResultSetExtractor<MemberDto> extractor = new ResultSetExtractor<MemberDto>() {

		@Override
		public MemberDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberPw(rs.getString("member_pw"));
				dto.setMemberNick(rs.getString("member_nick"));
				dto.setMemberBirth(rs.getDate("member_birth"));
				dto.setMemberTel(rs.getString("member_tel"));
				dto.setMemberEmail(rs.getString("member_email"));
				dto.setMemberPost(rs.getString("member_post"));
				dto.setMemberBaseAddress(rs.getString("member_base_address"));
				dto.setMemberDetailAddress(rs.getString("member_detail_address"));
				dto.setMemberPoint(rs.getInt("member_point"));
				dto.setMemberGrade(rs.getString("member_grade"));
				dto.setMemberJoin(rs.getDate("member_join"));
				dto.setMemberLogin(rs.getDate("member_login"));
				return dto;
			}else {
				return null;
			}
		}
	};
	
//	방법 1
//	insert into member(
//			아이디, 비밀번호, 닉네임, 생년월일, 전화번호, 
//			이메일, 우편번호, 기본주소, 상세주소)
//	values(?, ?, ?, ?, ?, ?, ?, ?, ?);
	
//	방법 2
//	insert into member(
//			아이디, 비밀번호, 닉네임, 생년월일, 전화번호, 
//			이메일, 우편번호, 기본주소, 상세주소, 포인트, 
//			등급, 가입일, 로그인일시)
//	values(?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '일반', sysdate, null);
	
	
	@Override
	public void insert(MemberDto memberDto) {
		String sql = "insert into member("
								+ "member_id, member_pw, member_nick, "
								+ "member_birth, member_tel, member_email, "
								+ "member_post, member_base_address, "
								+ "member_detail_address) "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = {
			memberDto.getMemberId(), memberDto.getMemberPw(),
			memberDto.getMemberNick(), memberDto.getMemberBirth(),
			memberDto.getMemberTel(), memberDto.getMemberEmail(),
			memberDto.getMemberPost(), memberDto.getMemberBaseAddress(),
			memberDto.getMemberDetailAddress()
		};
		jdbcTemplate.update(sql, param);
	}
	
	
	
	@Override
	public List<MemberDto> selectList() {
		String sql = "select * from member ";
		return jdbcTemplate.query(sql, mapper);
	}
	
	@Override
	public List<MemberDto> selectList(String type, String keyword) {
		String sql = "select * from member "
						+ "where instr(#1, ?) > 0 "
						+ "order by #1 asc";
		sql = sql.replace("#1", type);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	@Override
	public MemberDto selectOne(String memberNick) {
			String sql  = "select * from member where member_nick=?";
			Object[] param = {memberNick};
		return jdbcTemplate.query(sql, extractor,param);
	}
}


