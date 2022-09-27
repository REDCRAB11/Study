package com.kh.springhome.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.entity.AttachmentDto;
import com.kh.springhome.error.TargetNotFoundException;
import com.kh.springhome.repository.AttachmentDao;

@RestController // @Controller + @ResponseBody 합친거 
@RequestMapping("/attachment")
public class AttachmentController {
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	private final 	File dir = new File(System.getProperty("user.home")+"/upload");

	
	@GetMapping("/download/{attachmentNo}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable int attachmentNo) throws IOException{
				AttachmentDto dto = attachmentDao.selectOne(attachmentNo);
				if(dto == null) {
					throw new TargetNotFoundException("존재하지 않는 파일");
				}
				
				File target = new File(dir, String.valueOf(attachmentNo));
				byte[] data = FileUtils.readFileToByteArray(target);
				ByteArrayResource resource = new ByteArrayResource(data);
				
				return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_ENCODING, 
												StandardCharsets.UTF_8.name())
				.contentLength(dto.getAttachmentSize())
				.header(HttpHeaders.CONTENT_TYPE, dto.getAttachmentType())
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
				.filename(dto.getAttachmentName(), StandardCharsets.UTF_8)
				.build()
				.toString())
				.body(resource);
	}
}
