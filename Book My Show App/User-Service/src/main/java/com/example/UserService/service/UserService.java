package com.example.UserService.service;

import com.example.UserService.dto.UserDto;
import com.example.UserService.exception.UserNotFoundException;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(String userId);

    List<UserDto> getAllUsers();

    boolean deleteUserById(String userId);

    UserDto updateSpecificField(String userId, Map<String, Object> fields) throws UserNotFoundException;
}
