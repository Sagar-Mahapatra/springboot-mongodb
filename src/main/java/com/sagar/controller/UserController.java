package com.sagar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.model.User;
import com.sagar.repository.UserRepository;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	private UserRepository repo;

	@PostMapping("/add")
	public ResponseEntity<User> adduser(@RequestBody User user) {
		User savedUser = repo.save(user);
		return ResponseEntity.ok(savedUser);
	}

}
