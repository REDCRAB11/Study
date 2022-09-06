package com.kh.springhome.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
	
}

