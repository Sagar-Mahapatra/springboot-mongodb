package com.sagar.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.model.User;
import com.sagar.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {

	@Autowired
	private UserRepository repo;

	@PostMapping("/add")
	public ResponseEntity<User> adduser(@RequestBody @Valid User user) {
		User savedUser = repo.save(user);
		return ResponseEntity.ok(savedUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getuser(@PathVariable("id") String id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			log.error("User Not Found with Id:" + id);
			throw new RuntimeException("User Not Found with Id:" + id);
		}

	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAlluser() {
		return ResponseEntity.ok(repo.findAll());
	}

}
