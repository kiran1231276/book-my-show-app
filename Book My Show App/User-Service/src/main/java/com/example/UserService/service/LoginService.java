package com.example.UserService.service;

import com.example.UserService.dto.LoginDto;

public interface LoginService {
    String loginUser(LoginDto loginDto);
}