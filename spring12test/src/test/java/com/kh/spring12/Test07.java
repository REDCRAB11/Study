package com.kh.spring12;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class Test07 {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void pocketMonsgerInsertTest() throws Exception {
		mockMvc.perform(
						post("/pocketmon/insert")
								.param("no","77" )
								.param("name", "디그다")
								.param("type", "풀")
						)
						.andExpect(status().is3xxRedirection())  
						.andDo(print()) 
						.andReturn();
		
}
}
