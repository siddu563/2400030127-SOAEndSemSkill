package com.example.lab2;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.lab2.controller.UserController;
import com.example.lab2.dto.UserResponse;
import com.example.lab2.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private UserService userService;

	@Test
	void getUserByIdReturnsMockedUser() throws Exception {
		when(userService.getUserById(1L))
				.thenReturn(new UserResponse(1L, "Siddu", "siddu@example.com"));

		mockMvc.perform(get("/api/users/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.name").value("Siddu"))
				.andExpect(jsonPath("$.email").value("siddu@example.com"));

		verify(userService).getUserById(1L);
	}
}
