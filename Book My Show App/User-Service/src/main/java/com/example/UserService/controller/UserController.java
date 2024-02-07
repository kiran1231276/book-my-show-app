package com.example.UserService.controller;

import com.example.UserService.dto.LoginDto;
import com.example.UserService.dto.UserDto;
import com.example.UserService.service.LoginService;
import com.example.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/registration")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
        String result = loginService.loginUser(loginDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId){
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtoList = userService.getAllUsers();
        return ResponseEntity.ok(userDtoList);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        boolean isDeleted = userService.deleteUserById(userId);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully......");
        } else {
            return ResponseEntity.badRequest().body("User with given id is not found.....");
        }
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserDto> updateSpecificField(@PathVariable String userId,@RequestBody Map<String, Object> fields){
        UserDto updatedUser = userService.updateSpecificField(userId, fields);
        return ResponseEntity.ok(updatedUser);
    }

}
