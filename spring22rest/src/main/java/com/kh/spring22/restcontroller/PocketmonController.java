package com.kh.spring22.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring22.entity.PocketMonsterDto;
import com.kh.spring22.repository.PocketMonsterDao;


@RestController
@RequestMapping("/rest")
public class PocketmonController {
	
	@Autowired
	private PocketMonsterDao dao;
	
	@GetMapping("/pocketmon")
	public List<PocketMonsterDto> list(){
		return dao.list();
	}
	
	@GetMapping("/pocketmon/{no}")
	public PocketMonsterDto find(@PathVariable int no) {
		return dao.find(no);
	}

	@PostMapping("/pocketmon") //--> 등록
	public void insert(@RequestBody PocketMonsterDto dto) {
		dao.insert(dto);
	}
	
	//PUT 방식은 POST 처럼 데이터를 Body에 전송할 수 있는 방식  --> 수정 
	@PutMapping("/pocketmon")
	public boolean edit(@RequestBody PocketMonsterDto dto) {
		return dao.edit(dto);
	}
	
	@DeleteMapping("/pocketmon/{no}")// --> 삭제,, 리다이렉트할필요 없음 {no} 만들어서 
	public boolean delete(@PathVariable int no) {
		return dao.delete(no);
	}
}