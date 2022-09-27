package com.kh.spring13.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring13.entity.AttachmentDto;
import com.kh.spring13.repository.AttachmentDao;

@Controller
public class FileController {
	
	@GetMapping("/") 
	public String root() {
		return "root";
	}
	
	//컨트롤러에서의 파일 수신 처리
	// -> Multipart Request를 처리한다고 부름
	// -> Spring boot 에서 내부적으로 multipartResolver를 등록
	// -> Spring Controller에서는 MultipartFile 형태로 파일을 수신
	// -> 기존에 사용하던 annotation 전부 지원
	@PostMapping("/")
	public String upload(
			@RequestParam String uploader,
			@RequestParam MultipartFile attachment) throws IllegalStateException, IOException {
		System.out.println("uploader = " + uploader);
		System.out.println("attachment = " + attachment);
		//attachment 분석
		System.out.println("content type = " + attachment.getContentType());
		System.out.println("name = " + attachment.getName());
		System.out.println("original file name = " + attachment.getOriginalFilename());
		System.out.println("size = " + attachment.getSize());
		
		//사용자가 올린 파일을 저장
//		File directory = new File("D:/upload");//업로드할 폴더 선택
		File directory = new File(
						System.getProperty("user.home")+"/upload");
		directory.mkdirs();//폴더 생성 명령
		File target = new File(directory, 
							attachment.getOriginalFilename());//저장될 파일 생성
		attachment.transferTo(target);//실제 저장 처리 명령
		
		return "redirect:/";
	}
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@PostMapping("/upload")
	public String upload(@RequestParam MultipartFile attachment) throws IllegalStateException, IOException {
		//DB 저장
		int attachmentNo = attachmentDao.sequence();
		attachmentDao.insert(AttachmentDto.builder()
							.attachmentNo(attachmentNo)
							.attachmentName(attachment.getOriginalFilename())
							.attachmentType(attachment.getContentType())
							.attachmentSize(attachment.getSize())
						.build());
		
		//파일 저장
		File dir = new File(
				System.getProperty("user.home")+"/upload");
		dir.mkdirs();
		File target = new File(dir, String.valueOf(attachmentNo));
		attachment.transferTo(target);
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", attachmentDao.selectList());
		return "list";
	}
	
	@GetMapping("/download")
	public ResponseEntity<ByteArrayResource> download(
									@RequestParam int attachmentNo) throws IOException {
		//[1] 파일 탐색(DB)
		AttachmentDto dto = attachmentDao.selectOne(attachmentNo);
		if(dto == null) {//파일이 없으면
			return ResponseEntity.notFound().build();//404 error 전송
		}
		
		//[2] 파일 불러오기
		File dir = new File(
				System.getProperty("user.home")+"/upload");
		File target = new File(dir, String.valueOf(attachmentNo));
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource resource = new ByteArrayResource(data);
		
		//[3] 응답 객체를 만들어 데이터를 전송
		return ResponseEntity.ok()
//		.header("Content-Encoding", "UTF-8")
		.header(HttpHeaders.CONTENT_ENCODING, 
										StandardCharsets.UTF_8.name())
//		.header("Content-Length", String.valueOf(dto.getAttachmentSize()))
		.contentLength(dto.getAttachmentSize())
		
//		.header("Content-Type", dto.getAttachmentType())
		.contentType(MediaType.APPLICATION_OCTET_STREAM)
		
//		.header("Content-Disposition", "attachment; filename="+dto.getAttachmentName())
		.header(HttpHeaders.CONTENT_DISPOSITION, 
							ContentDisposition.attachment()
									.filename(
											dto.getAttachmentName(), 
											StandardCharsets.UTF_8)
									.build().toString())
		.body(resource);
	}
	
}
