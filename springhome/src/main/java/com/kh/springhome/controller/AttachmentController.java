package com.kh.springhome.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.service.AttachmentService;

@RestController//@Controller + @ResponseBody
@RequestMapping("/attachment")
public class AttachmentController {
	
	@Autowired
	private AttachmentService attachmentService;
	
	@GetMapping("/download/{attachmentNo}")
	public ResponseEntity<ByteArrayResource> download(
			@PathVariable int attachmentNo) throws IOException{
		return attachmentService.load(attachmentNo);
	}
	
}



