package com.kh.spring10.entity;

import java.sql.Date;

public class BookDto {
	private int serial;
	private String name;
	private String writer;
	private String publisher;
	private int price;
	private String genre;
	private Date creationTime;
	public BookDto() {
		super();
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	@Override
	public String toString() {
		return "BookDto [serial=" + serial + ", name=" + name + ", writer=" + writer + ", publisher=" + publisher
				+ ", price=" + price + ", genre=" + genre + ", creationTime=" + creationTime + "]";
	}

	
}
