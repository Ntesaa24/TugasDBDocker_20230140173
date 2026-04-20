package com.praktikumDB.deploy.controller;


import com.praktikumDB.deploy.model.User;
import com.praktikumDB.deploy.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public String createUser(@RequestBody User request){
		userService.addUSer(request);
		return "user created successfully";
	}

	@GetMapping
	public List<User> getAllUser(){
		return userService.getAllUser();
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return "User deleted successfully";
	}

	@GetMapping("/{id}")
	public String updateUser(@PathVariable String id, @RequestBody User request){
		userService.updateUSer(id, request);
		return "user updated successfully";
	}
}
