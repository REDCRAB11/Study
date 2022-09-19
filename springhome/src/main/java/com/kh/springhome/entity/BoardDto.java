package com.kh.springhome.entity;

import java.sql.Date;

public class BoardDto {

	private int boardNo, boardRead, boardLike;
	private String boardWriter, boardTitle, boardContent, boardHead;
	private Date boardWriteTime, boardUpdateTime;
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getBoardRead() {
		return boardRead;
	}
	public void setBoardRead(int boardRead) {
		this.boardRead = boardRead;
	}
	public int getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardHead() {
		return boardHead;
	}
	public void setBoardHead(String boardHead) {
		this.boardHead = boardHead;
	}
	public Date getBoardWriteTime() {
		return boardWriteTime;
	}
	public void setBoardWriteTime(Date boardWriteTime) {
		this.boardWriteTime = boardWriteTime;
	}
	public Date getBoardUpdateTime() {
		return boardUpdateTime;
	}
	public void setBoardUpdateTime(Date boardUpdateTime) {
		this.boardUpdateTime = boardUpdateTime;
	}
	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", boardRead=" + boardRead + ", boardLike=" + boardLike
				+ ", boardWriter=" + boardWriter + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardHead=" + boardHead + ", boardWriteTime=" + boardWriteTime + ", boardUpdateTime="
				+ boardUpdateTime + "]";
	}
	public BoardDto() {
		super();
	} 
	
	
}
