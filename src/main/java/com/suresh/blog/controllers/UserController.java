package com.suresh.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.suresh.blog.payloads.ApiResponse;
import com.suresh.blog.payloads.UserDto;
import com.suresh.blog.services.UserService;

@Controller
public class UserController {
	// create User :Post
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

	}

	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userid) {

		UserDto updateUser = this.userService.updateUser(userDto, userid);
		return ResponseEntity.ok(updateUser);

	}

	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userid) {
		this.userService.deleteUserById(userid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User is deleted", true), HttpStatus.OK);

	}

	// get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> allUsers = this.userService.getAllUsers();
		return ResponseEntity.ok(allUsers);

	}

	@GetMapping("/{userid}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userid) {
		UserDto userById = this.userService.getUserById(userid);
		return ResponseEntity.ok(userById);

	}

}
