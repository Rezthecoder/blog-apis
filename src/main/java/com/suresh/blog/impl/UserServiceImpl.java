package com.suresh.blog.impl;

import com.suresh.blog.entity.User;
import com.suresh.blog.exceptions.ResourceNotFoundException;
import com.suresh.blog.payloads.UserDto;
import com.suresh.blog.repository.UserRepo;
import com.suresh.blog.services.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepo userRepo;

  @Override
  public UserDto createUser(UserDto userDto) {
    User dtoToUser = this.dtoToUser(userDto);

    User savedUser = this.userRepo.save(dtoToUser);
    return this.userToDto(savedUser);
  }

  @Override
  public UserDto updateUser(UserDto userdto, Integer userId) {
    User user =
      this.userRepo.findById(userId)
        .orElseThrow(
          () -> new ResourceNotFoundException("User", " id", userId)
        );

    user.setAbout(userdto.getAbout());
    user.setEmail(userdto.getEmail());
    user.setName(userdto.getName());
    user.setPassword(userdto.getPassword());
    User updatedUser = this.userRepo.save(user);

    return this.userToDto(updatedUser);
  }

  @Override
  public UserDto getUserById(Integer userId) {
    User user =
      this.userRepo.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    UserDto userToDto = this.userToDto(user);

    return userToDto;
  }

  @Override
  public List<UserDto> getAllUsers() {
    List<User> users = this.userRepo.findAll();
    List<UserDto> userDtos = users
      .stream()
      .map(user -> this.userToDto(user))
      .collect(Collectors.toList());
    return userDtos;
  }

  @Override
  public void deleteUserById(Integer userId) {
    User user =
      this.userRepo.findById(userId)
        .orElseThrow(
          () -> new ResourceNotFoundException("User", " id", userId)
        );
    this.userRepo.delete(user);
  }

  private User dtoToUser(UserDto userDto) {
    User user = new User();
    user.setId(userDto.getId());
    user.setAbout(userDto.getAbout());
    user.setEmail(userDto.getEmail());
    user.setName(userDto.getName());
    user.setPassword(userDto.getPassword());
    return user;
  }

  private UserDto userToDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setAbout(user.getAbout());
    userDto.setEmail(user.getEmail());
    userDto.setName(user.getName());
    userDto.setPassword(user.getPassword());
    return userDto;
  }
}
