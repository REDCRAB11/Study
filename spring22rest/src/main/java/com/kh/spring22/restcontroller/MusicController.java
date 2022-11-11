package com.kh.spring22.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring22.entity.MusicDto;
import com.kh.spring22.repository.MusicDao;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/rest")
public class MusicController {
	
	@Autowired
	private MusicDao dao;
	
	@GetMapping("/music")
	public List<MusicDto> list(){
		return dao.list();
	}
	
	@GetMapping("/music/{no}")
	public MusicDto find(@PathVariable int no) {
		return dao.find(no);
	}
	
	@PostMapping("/music")
	public void insert(@RequestBody MusicDto dto) {
		dao.insert(dto);
	}
	
	@PutMapping("/music")
	public boolean eidt(@RequestBody MusicDto dto) {
		return dao.edit(dto);
	}
	
	@DeleteMapping("/music/{no}")
	public boolean delete(@PathVariable int no) {
		return dao.delete(no);
	}
	
}
