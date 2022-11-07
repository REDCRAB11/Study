package com.kh.spring16.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class MusicDto {
	private int musicNo;
	private String musicTitle;
	private String musicArtist;
	private String musicAlbum;
	private int musicPlay;
	private Date releaseTime;
}
