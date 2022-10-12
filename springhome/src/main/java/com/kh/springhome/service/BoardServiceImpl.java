package com.kh.springhome.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springhome.entity.AttachmentDto;
import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.repository.AttachmentDao;
import com.kh.springhome.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	private final File directory = new File("D:/upload");
	
	@Override
	public int write(BoardDto boardDto, List<MultipartFile> attachment) throws IllegalStateException, IOException {
//		등록될 글의 번호를 미리 생성
		int boardNo = boardDao.sequence();
		boardDto.setBoardNo(boardNo);

//		등록 전에 "새글"인지 "답글"인지 파악해서 그에 맞는 계산을 수행
		if(boardDto.getBoardParent() == 0) {//새글이라면
			boardDto.setBoardGroup(boardNo);
			boardDto.setBoardParent(0);
			boardDto.setBoardDepth(0);
		}
		else {//답글이라면 
			BoardDto parentDto = boardDao.selectOne(
													boardDto.getBoardParent());
			boardDto.setBoardGroup(parentDto.getBoardGroup());
			boardDto.setBoardDepth(parentDto.getBoardDepth() + 1);
		}
		
//		문제점 : 등록은 되는데 몇 번인지 알 수 없다
//		해결책 : 번호를 미리 생성하고 등록하도록 메소드 변경
		boardDao.insert2(boardDto);
		
//		(+추가) 게시글이 등록된 다음 파일이 있다면 해당 파일을 등록 및 연결
//		- 첨부파일이 없어도 리스트에는 1개의 객체가 들어있다
		for(MultipartFile file : attachment) {
			if(!file.isEmpty()) {
				System.out.println("첨부파일 발견");
				
				//DB 등록
				int attachmentNo = attachmentDao.sequence();
				attachmentDao.insert(AttachmentDto.builder()
							.attachmentNo(attachmentNo)
							.attachmentName(file.getOriginalFilename())
							.attachmentType(file.getContentType())
							.attachmentSize(file.getSize())
						.build());
				
				//파일 저장
				File target = new File(directory, String.valueOf(attachmentNo));
				System.out.println(target.getAbsolutePath());
				file.transferTo(target);
				
				//+ 연결 테이블에 연결 정보를 저장(게시글번호, 첨부파일번호)
				boardDao.connectAttachment(boardNo, attachmentNo);
			}
		}
		return boardNo;
	}
	
	@Override
	public boolean remove(int boardNo) {
		//삭제가 이루어지기 전에 삭제될 게시글의 첨부파일 정보를 조회
		List<AttachmentDto> attachmentList = 
					attachmentDao.selectBoardAttachmentList(boardNo);
		
		//삭제 - 자동으로 board_attachment의 데이터가 연쇄 삭제됨
		boolean result = boardDao.delete(boardNo);
		
		if(result) {
			for(AttachmentDto attachmentDto : attachmentList) {
				//첨부파일(attachment) 테이블 삭제
				attachmentDao.delete(attachmentDto.getAttachmentNo());
				//실제 파일 삭제
				String filename = String.valueOf(attachmentDto.getAttachmentNo());
				File target = new File(directory, filename);
				target.delete();
			}
		}
		return result;
	}
	
}
