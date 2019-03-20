package org.dico.rh.controllers;

import java.util.List;

import org.dico.rh.models.User;
import org.dico.rh.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> get() throws Exception {
		List<User> records = userService.get();
		return records.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(records);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable("id") int id) throws Exception {
		User record = userService.get(id);
		return record == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(record);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) throws Exception {
		user = userService.insert(user);
		return user == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(user);
	}
	
	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user) throws Exception {
		user = userService.update(user);
		return user == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(user);
	}
}
