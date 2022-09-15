package com.kh.spring12;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//PocketMonsterController의 정상 작동 테스트
@SpringBootTest
public class Test05 {

	//가짜 요청 생성 도구
	private MockMvc mockMvc;
	
	//가짜 테스트를 수행할 수 있도록 환경을 구성하는 도구
	@Autowired
	private WebApplicationContext ctx;
	
	@BeforeEach
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void test() throws Exception {
		//assertNotNull(ctx);
		
		mockMvc.perform(get("/pocketmon/insert"))
						.andExpect(status().is(200))
						.andDo(print())
						.andReturn();
	}
	
}