package com.example.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Model_act.User;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller_act {

	private final List<User> users = new ArrayList<>();

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		users.add(user);
		return user;
	}

	@GetMapping("/users")
	public List<User> listUsers() {
		return users;
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		for (User u : users) {
			if (u.getId() == id) {
				return ResponseEntity.ok(u);
			}
		}
		return ResponseEntity.notFound().build();
	}

	

}
