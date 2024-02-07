package com.example.UserService.service.impl;

import com.example.UserService.dto.LoginDto;
import com.example.UserService.entity.User;
import com.example.UserService.repository.UserRepository;
import com.example.UserService.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String loginUser(LoginDto loginDto) {
        String userName = loginDto.getUserName();
        String password = loginDto.getPassword();

        // Fetch user by username from the database
        Optional<User> userOptional = userRepository.findByUserName(userName);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Check if the password matches
            if (password.equals(user.getPassword())) {
                return "Successfully logged in.....!";
            } else {
                return "Invalid password please provide correct password......!";
            }
        } else {
            return "User not found with given userName....!";
        }
    }
}
