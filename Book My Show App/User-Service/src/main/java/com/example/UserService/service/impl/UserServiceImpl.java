package com.example.UserService.service.impl;

import com.example.UserService.dto.UserDto;
import com.example.UserService.entity.User;
import com.example.UserService.exception.UserNotFoundException;
import com.example.UserService.repository.UserRepository;
import com.example.UserService.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.save(user);
        return mapUserToDto(savedUser);
    }


    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User with given id is not found.."+userId));
        return mapUserToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> userList = userRepository.findAll();
       List<UserDto> userDtoList = new ArrayList<>();
       for (User user : userList){
           userDtoList.add(mapUserToDto(user));
       }
        return userDtoList;
    }

    @Override
    public boolean deleteUserById(String userId) {
       User user = userRepository.findById(userId)
               .orElseThrow(()-> new UserNotFoundException("User with given id is not found"+userId));
       userRepository.delete(user);
        return true;
    }

    @Override
    public UserDto updateSpecificField(String userId, Map<String, Object> fields) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with given id..." + userId));
        fields.forEach((key,value)-> setField(user,key,value));
        User savedUser = userRepository.save(user);
        return mapUserToDto(savedUser);
    }

    // Helper method to map user entity to userDto
    private UserDto mapUserToDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    // Helper method to set field dynamically using ReflectionUtils

    private void setField(User user,String fieldName,Object value){
        Optional.ofNullable(ReflectionUtils.findField(User.class,fieldName))
                .ifPresent(field -> {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field,user,value);
                });
    }
}
