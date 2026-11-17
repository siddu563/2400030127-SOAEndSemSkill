package com.example.lab2.service;

import org.springframework.stereotype.Service;

import com.example.lab2.dto.UserResponse;

@Service
public class UserService {

	public UserResponse getUserById(Long id) {
		return new UserResponse(id, "Siddu", "siddu@example.com");
	}
}
