package com.example.lab2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms1")
public class MS1Controller {

	@GetMapping("/add")
	public ResponseEntity<String> add(@RequestParam int a, @RequestParam int b) {
		return ResponseEntity.ok("MS 1.1 - Addition = " + (a + b));
	}
}
