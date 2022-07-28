package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test1 {

	@PreAuthorize("hasAuthority('Users')")
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
}
