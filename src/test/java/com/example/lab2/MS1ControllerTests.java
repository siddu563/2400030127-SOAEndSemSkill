package com.example.lab2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.lab2.controller.MS1Controller;

@WebMvcTest(MS1Controller.class)
class MS1ControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void addEndpointReturnsSumForGivenInputs() throws Exception {
		mockMvc.perform(get("/ms1/add").param("a", "5").param("b", "10"))
				.andExpect(status().isOk())
				.andExpect(content().string("MS 1.1 - Addition = 15"));
	}
}



