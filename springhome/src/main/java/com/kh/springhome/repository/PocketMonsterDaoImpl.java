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

import com.kh.springhome.entity.PocketMonsterDto;
import com.kh.springhome.vo.PocketMonsterCountVO;

@Repository
public class PocketMonsterDaoImpl implements PocketMonsterDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<PocketMonsterDto> mapper = new RowMapper<PocketMonsterDto>() {
		@Override
		public PocketMonsterDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			PocketMonsterDto dto = new PocketMonsterDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setType(rs.getString("type"));
			return dto;
		}
	};
	
	private ResultSetExtractor<PocketMonsterDto> extractor = new ResultSetExtractor<PocketMonsterDto>() {
		@Override
		public PocketMonsterDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				PocketMonsterDto dto = new PocketMonsterDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setType(rs.getString("type"));
				return dto;
			}
			else {
				return null;
			}
		}
	};

	@Override
	public void insert(PocketMonsterDto pocketMonsterDto) {
		String sql = "insert into pocket_monster(no, name, type) "
							+ "values(?, ?, ?)";
		Object[] param = {
				pocketMonsterDto.getNo(),
				pocketMonsterDto.getName(),
				pocketMonsterDto.getType()
		};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<PocketMonsterDto> selectList() {
		String sql = "select * from pocket_monster order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
	@Override
	public PocketMonsterDto selectOne(int no) {
		String sql = "select * from pocket_monster where no = ?";
		Object[] param = {no};
		return jdbcTemplate.query(sql, extractor, param);
	}
	
	@Override
	public boolean update(PocketMonsterDto dto) {
		String sql = "update pocket_monster "
							+ "set name=?, type=? where no=?";
		Object[] param = {
				dto.getName(), dto.getType(), dto.getNo()
		};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public boolean delete(int no) {
		String sql = "delete pocket_monster where no = ?";
		Object[] param = {no};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	//PocketMonsterCountVO에 대한 RowMapper
	private RowMapper<PocketMonsterCountVO> countMapper = new RowMapper<PocketMonsterCountVO>() {
		@Override
		public PocketMonsterCountVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			PocketMonsterCountVO vo = new PocketMonsterCountVO();
			vo.setType(rs.getString("type"));
			vo.setCnt(rs.getInt("cnt"));
			return vo;
		}
	};

	@Override
	public List<PocketMonsterCountVO> selectCountList() {
		String sql = "select type, count(*) cnt from pocket_monster "
							+ "group by type order by cnt desc";
		return jdbcTemplate.query(sql, countMapper);
	}

	@Override
	public List<PocketMonsterDto> selectListForMain() {
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from pocket_monster order by no desc"
							+ ")TMP"
						+ ") where rn between 1 and 3";
		return jdbcTemplate.query(sql, mapper);
	}
}








