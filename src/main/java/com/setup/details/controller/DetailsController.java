package com.setup.details.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setup.details.dto.User;

@RestController
@RequestMapping("/setup/details/")
public class DetailsController {
	// http://localhost:8077/setup/details/user
	@GetMapping(value="user")
	public User getUsers() {
		return User.builder()
				.id(12)
				.username("dks")
				.email("dks@email.com")
				.profile("Test profile")
				.mob("+00 9899120193")
				.build();
	}
	
}
