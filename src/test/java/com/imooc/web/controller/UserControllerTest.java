package com.imooc.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mocMvc;
	
	@Before
	public void setup(){
		mocMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void whenQuerySuccess() throws Exception {
		mocMvc.perform(get("/user")
				.param("username", "jojo")
				.param("age", "18")
				.param("ageTo", "50")
				.param("page", "1")
				.param("size", "10")
				.param("sort", "age,desc")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(3));
	}
}
