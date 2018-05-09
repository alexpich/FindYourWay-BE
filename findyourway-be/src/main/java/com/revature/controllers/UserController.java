package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@Valid @RequestBody User newUser) {
		return userService.addUser(newUser);
	}
	
	@PutMapping(produces="application/json", consumes=MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@Valid @RequestBody User updatedUser) {
		return userService.updateUserById(updatedUser);
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
	
	@GetMapping(value="/list/{roleId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllUsersById(@PathVariable Integer roleId) {
		return userService.findAllUsersByRoleId(roleId);
	}
	
	@PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User loginUser(@RequestBody User user) {
		return userService.loginUser(user);
	}
	
	@DeleteMapping(produces="application/json", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteUser(@Valid @RequestBody User user) {
		return userService.deleteUser(user);
	}
}
