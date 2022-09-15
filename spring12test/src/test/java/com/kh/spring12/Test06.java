package com.kh.spring12;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//PocketMonsterController의 정상 작동 테스트
@SpringBootTest
@AutoConfigureMockMvc // MockMvc에 대한 자동 설정 
public class Test06 {

	//가짜 요청 생성 도구
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/pocketmon/insert")) //GET 요청 생성
						.andExpect(status().is(200)) // 상태가 200번인 경우만 성공 
						.andExpect(status().is2xxSuccessful()) // 상태가 2xx인 경우 성공 
						.andDo(print()) // 추가로 프린트 해라 
						.andReturn(); // 끝
	}
	
}