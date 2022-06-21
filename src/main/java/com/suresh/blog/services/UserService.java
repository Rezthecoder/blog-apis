package com.suresh.blog.services;

import java.util.List;

import com.suresh.blog.payloads.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUserById(Integer userId);
	
	

}
