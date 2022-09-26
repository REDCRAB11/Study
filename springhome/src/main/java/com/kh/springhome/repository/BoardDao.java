package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.vo.BoardListSearchVO;
import com.kh.springhome.vo.BoardListVO;

public interface BoardDao {
	void insert(BoardDto boardDto);//번호를 만들면서 등록하는 메소드
	int sequence();//시퀀스 발행 메소드
	void insert2(BoardDto boardDto);//번호까지 합쳐서 등록하는 메소드
	
	List<BoardDto> selectList();//더이상 사용 x
	
	//통합 검색 메소드(목록+검색)
	List<BoardListVO> selectList(BoardListSearchVO vo);
	List<BoardListVO> list(BoardListSearchVO vo);
	List<BoardListVO> search(BoardListSearchVO vo);
	
	//검색과 목록의 총 데이터 개수를 구하는 메소드(마지막 페이지 번호)
	int count(BoardListSearchVO vo);
	int searchCount(BoardListSearchVO vo);
	int listCount(BoardListSearchVO vo);
	
	BoardDto selectOne(int boardNo);
	BoardDto read(int boardNo);//조회수 증가까지
	
	boolean updateReadcount(int boardNo);
	boolean update(BoardDto boardDto);
	
	void clear();
	boolean delete(int boardNo);
	
	List<BoardDto> selectWriteList(String boardWriter, int begin, int end);
	List<BoardDto> selectLikeList(String boardWriter, int begin, int end);
	List<BoardListVO> selectListForMain();
}



